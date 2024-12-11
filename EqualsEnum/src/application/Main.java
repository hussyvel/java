package application;

import entities.Moeda;

public class Main {

    public static void main(String[] args) {
        for (Moeda moeda : Moeda.values()){
            System.out.println(moeda.name() + moeda.getSimbolo());
        }
    }

}