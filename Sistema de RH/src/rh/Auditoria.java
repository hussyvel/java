package rh;

public class Auditoria {

    public void auditar(Funcionario funcionario) {

        System.out.println("Iniciando auditoria no funcionário " + funcionario.getNome());

        //departamento pode ser acessado default, ou seja, dentro da classe e pacote
        System.out.println("Departamento atual" + funcionario.departamento);

        //bater o ponto é protected, mesma classe, mesmo pacote e subclasse;
        funcionario.baterPonto();
    }
}
