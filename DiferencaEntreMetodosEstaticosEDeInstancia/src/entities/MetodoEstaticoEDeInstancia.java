package entities;

public class MetodoEstaticoEDeInstancia {

    public int instanciarVar = 10;
    public static int staticVar = 20;

    public void metodoInstancia(){
        System.out.println("Método de instância: " + instanciarVar);
    }

    public static void metodoEstatico(){
        System.out.println("Método estático: " + staticVar);
    }

}
