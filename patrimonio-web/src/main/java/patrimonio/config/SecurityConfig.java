package patrimonio.config;

import patrimonio.model.Usuario;
import patrimonio.repository.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UsuarioRepository usuarioRepo;

    public SecurityConfig(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return login -> {
            Usuario u = usuarioRepo.findByLogin(login)
                    .filter(Usuario::isAtivo)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + login));
            return new org.springframework.security.core.userdetails.User(
                    u.getLogin(),
                    u.getSenha(),
                    List.of(new SimpleGrantedAuthority("ROLE_" + u.getPerfil().name()))
            );
        };
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(provider);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/api/auth/esqueci-senha").permitAll()
                .requestMatchers("/", "/index.html", "/*.js", "/*.css").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/bens/**").authenticated()
                .requestMatchers("/api/movimentacoes/**").authenticated()
                .requestMatchers("/api/usuarios/**").hasRole("ADMIN")
                .requestMatchers("/api/relatorios/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .sessionManagement(s -> s
                .maximumSessions(5)
            )
            .formLogin(AbstractHttpConfigurer::disable)
            .httpBasic(AbstractHttpConfigurer::disable)
            .logout(logout -> logout
                .logoutUrl("/api/auth/logout")
                .logoutSuccessHandler((req, res, auth) -> res.setStatus(200))
            );
        return http.build();
    }
}
