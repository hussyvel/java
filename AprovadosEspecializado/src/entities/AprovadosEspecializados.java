package entities;

public class AprovadosEspecializados {

        private String name;
        private double nota1;
        private double nota2;

        public AprovadosEspecializados(String name, double nota1, double nota2){
            this.name = name;
            this.nota1 = nota1;
            this.nota2 = nota2;
        }

        public String getName() {
            return name;
        }

        public double calcularNotas() {
            return (nota1 + nota2) / 2;
        }

        public boolean aprovados(){
            return calcularNotas() < 6.0;
        }

}
