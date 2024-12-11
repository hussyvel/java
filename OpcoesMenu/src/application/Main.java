package application;

import entities.OpcoesMenu;

public class Main {
    public static void main(String[] args) {
        for (OpcoesMenu opcao : OpcoesMenu.values()){
            System.out.println("Opção: " + opcao.name() + " | valor: " + opcao.getOpcao());
        }

        OpcoesMenu variavel = OpcoesMenu.SALVAR;
        System.out.println("Você selecionou: " + variavel.name() + " | valor: " + variavel.getOpcao());
    }
}