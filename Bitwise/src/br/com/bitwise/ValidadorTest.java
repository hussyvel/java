package br.com.bitwise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ValidadorTest {

    @Nested
    @DisplayName("Usuario")
    class UsuarioTest {

        @Test
        void deveGuardarONome() {
            assertEquals("Hussyvel", new Usuario("Hussyvel", true).getNome());
        }

        @Test
        void deveManterUsuarioAtivo() {
            assertTrue(new Usuario("Ana", true).isAtivo());
        }

        @Test
        void deveManterUsuarioInativo() {
            assertFalse(new Usuario("Ana", false).isAtivo());
        }
    }

    @Nested
    @DisplayName("Validador.ehValido")
    class EhValidoTest {

        private final ServicoExterno servicoEco = usuario -> usuario;

        @Test
        void deveRetornarTrueParaUsuarioAtivo() {
            assertTrue(Validador.ehValido(new Usuario("Ana", true), servicoEco));
        }

        @Test
        void deveRetornarFalseParaUsuarioInativo() {
            assertFalse(Validador.ehValido(new Usuario("Ana", false), servicoEco));
        }

        @Test
        void deveRetornarFalseParaUsuarioNulo() {
            assertFalse(Validador.ehValido(null, servicoEco));
        }

        @Test
        void naoDeveChamarServicoQuandoUsuarioForNulo() {
            AtomicInteger chamadas = new AtomicInteger();
            ServicoExterno servico = usuario -> {
                chamadas.incrementAndGet();
                return usuario;
            };

            Validador.ehValido(null, servico);

            assertEquals(0, chamadas.get());
        }

        @Test
        void deveConsultarServicoUmaVezComOUsuarioRecebido() {
            AtomicInteger chamadas = new AtomicInteger();
            Usuario usuario = new Usuario("Ana", true);
            ServicoExterno servico = recebido -> {
                chamadas.incrementAndGet();
                assertEquals(usuario, recebido);
                return recebido;
            };

            Validador.ehValido(usuario, servico);

            assertEquals(1, chamadas.get());
        }

        @Test
        void deveUsarOResultadoDoServicoEmVezDoUsuarioOriginal() {
            Usuario original = new Usuario("Ana", true);
            ServicoExterno servico = usuario -> new Usuario("Ana", false);

            assertFalse(Validador.ehValido(original, servico));
        }

        @Test
        void devePropagarExcecaoDoServico() {
            ServicoExterno servico = usuario -> {
                throw new IllegalStateException("servico fora do ar");
            };

            IllegalStateException e = assertThrows(IllegalStateException.class,
                    () -> Validador.ehValido(new Usuario("Ana", true), servico));
            assertEquals("servico fora do ar", e.getMessage());
        }

        @Test
        void deveLancarNullPointerQuandoServicoRetornaNulo() {
            ServicoExterno servico = usuario -> null;

            assertThrows(NullPointerException.class,
                    () -> Validador.ehValido(new Usuario("Ana", true), servico));
        }
    }
}
