package application;

import entities.MetodoEstaticoEDeInstancia;

public class Main {
    public static void main(String[] args) {
        //MetodoEstaticoEDeInstancia.metodoEstatico();

        MetodoEstaticoEDeInstancia obj = new MetodoEstaticoEDeInstancia();
        obj.metodoInstancia();
    }
}