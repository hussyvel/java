/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto;

/**
 *
 * @author hussyvel
 */

public abstract class Quadrilatero{

    protected double lado1, lado2, lado3, lado4;
    
    public Quadrilatero(double lado1,double lado2,double lado3, double lado4){
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.lado4 = lado4;
    }

    public double calcularPerimetro(double lado01){
        return this.lado1 + this.lado2;
    }
}