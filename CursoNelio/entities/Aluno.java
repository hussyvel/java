package CursoNelio.entities;

public class Aluno {

    public String nome;
    public double nota1, nota2, nota3;

    public double notasFinais() {
        return nota1 + nota2 + nota3;
    }

    public double calculandoNotas(){
        if(notasFinais() < 60){
            return 60.0 - notasFinais();
        } else {
            return 0.0;
        }
    }
}
