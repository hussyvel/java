package entities;

public enum OpcoesMenu {
    SALVAR(1), IMPRIMIR(2), ABRIR(3), VISUALIZAR(4), FECHAR(5);

    private final int Opcao;

    OpcoesMenu(int opcao) {
        this.Opcao = opcao;
    }

    public int getOpcao(){
        return Opcao;
    }
}
