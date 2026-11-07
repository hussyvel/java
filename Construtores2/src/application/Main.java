package application;

import entities.Usuario;

public class Main {

    public static void main(String[] args) {
        System.out.println("---Iniciando o Sistema---");

        Usuario novoUsuario = Usuario.criarNovoUsuario(123L);
        System.out.println("Criado com sucesso!" + novoUsuario);

        Usuario usuarioantigo = Usuario.retaurarDoBanco(123L, "Ativo");
        System.out.println("Retaurado com sucesso!" + usuarioantigo);

        System.out.println("---Finalizando o Sistema---");

    }
}
