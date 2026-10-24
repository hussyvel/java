package br.com.bitwise;

public class Validador {

    public static boolean ehValido(Usuario usuario, ServicoExterno servico){
        return usuario != null && servico.consultar(usuario).isAtivo();
    }
}
