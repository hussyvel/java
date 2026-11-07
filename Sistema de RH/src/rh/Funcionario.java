package rh;

public class Funcionario {

    //private : acessado dentro da classe
    private String nome;
    private double salario;
    private final String matricula;

    //DEFAULT (sem palavra): dentro da classe, mesmo pacote/pasta
    String departamento = "Tecnologia";

    //Public: mesma classe, mesma pasta ou pacote, subclasse e em qualquer lugar pode ser chamado ou criado um funcionário;
    public Funcionario(String nome, double matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }


    //getters e setters abertos para todo o sistema
    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double novoSalario) {
        if (novoSalario <= 0) {
            System.out.println("Erro: Salário inválido para " + nome);
            return;
        }
        this.salario = novoSalario;
    }

    protected void baterPonto(){
        System.out.println("Ponto atualizado com sucesso!" + this.matricula);
    }


}
