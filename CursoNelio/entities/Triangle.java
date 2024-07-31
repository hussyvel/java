package CursoNelio.entities;

    public class Triangle {

        //atributos do triângulo
        public double a, b, c;

        //método do triângulo
        public double area(){ //construtor
            double p = (a + b + c) / 2.0;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
}
