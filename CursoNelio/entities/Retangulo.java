package CursoNelio.entities;

public class Retangulo {

    public double width, height;

    public Retangulo(double height, double width){
        this.height = height;
        this.width = width;
    }

    public double area(){
        return width * width;
    }

    public double diagonal(){
        return Math.sqrt(width + height * height);
    }
}
