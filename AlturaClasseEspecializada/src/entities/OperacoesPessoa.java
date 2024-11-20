package entities;

import application.Pessoa;

public class OperacoesPessoa {
    private Pessoa[] pessoas;

    public OperacoesPessoa(Pessoa[] pessoas) {
        this.pessoas = pessoas;
    }

    public double calcularMediaAltura(){
        double somaAltura = 0.0;
        for (Pessoa pessoa : pessoas){
            somaAltura += pessoa.getAltura();
        }
        return somaAltura / pessoas.length;
    }

    public double calcularPercentagemDosMenoresQue16(){
        int cont = 0;
        for (Pessoa pessoa : pessoas){
            if (pessoa.getIdade() < 16){
                cont++;
            }
        }
        return (double) cont * 100.0 / pessoas.length;
    }

    public void imprimirNomesMenoresDe16(){
        System.out.println("Pessoas com menos de 16 anos: ");
        for (Pessoa pessoa : pessoas){
            if (pessoa.getIdade() < 16){
                System.out.println(pessoa.getNome());
            }
        }
    }
}