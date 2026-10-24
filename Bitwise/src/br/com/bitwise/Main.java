package br.com.bitwise;

/**
 * Os 7 operadores bitwise do Java, cada um com um caso em que especialistas
 * recomendam usá-lo e um caso em que recomendam evitá-lo.
 */
public class Main {

    public static void main(String[] args) {

        ServicoExterno servico = usuario -> usuario;

        Usuario usuarioAtivo = new Usuario("Hussyvel", true);
        Usuario usuarioNulo = null;

        System.out.println("Usuario ativo é valido?" + Validador.ehValido(usuarioAtivo, servico));
        System.out.println("Usuario nulo é válido? " + Validador.ehValido(usuarioNulo, servico));
    }
}