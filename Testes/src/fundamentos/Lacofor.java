/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fundamentos;

/**
 *
 * @author hussyvel
 */
public class Lacofor {
    public static void main(String[] args) {
        
        for(int contador = 1; contador <= 10; contador++){     
            
            System.out.println("Tabuada" + contador);
            
            for(int j = 1; j <= 10; j++){
                System.out.println(contador * j);
            }
        }    
    }
}
