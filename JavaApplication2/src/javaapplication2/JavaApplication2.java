/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author hussyvel
 */
class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Documento documento1;
        documento1 = new Documento();
        
        Documento documento2;
        documento2 = new Documento();
        
        Documento doc1 = new Documento();
        doc1.nome = "teste";
        
        Documento doc2 = doc1;
        doc2.nome = "Juliana";
        
        Carro carro1;
        carro1 = new Carro();
        
        Carro carro2;
        carro2 = new Carro();
        
        documento1.codigo = 12345;
        documento1.nome = "Hussyvel";
        documento1.foto = "Img1.jpg";
        documento1.dataNascimento = "11/09/2022";
        
        System.out.println(documento1.nome);
        
        documento2.codigo = 6789;
        documento2.nome = "Silva";
        documento2.foto = "Img2.jpg";
        documento2.dataNascimento = "11/12/2022";
        
        System.out.println(documento2.dataNascimento);
        System.out.println(doc2.nome);
        
        carro1.cor ="azul";
        carro1.marca = "Ferrari";
        carro1.modelo = 123654;
        carro1.placa = 654321;
        carro1.tipo = "Ford";
        
        carro2.cor = "branco";
        carro2.marca = "Ford";
        carro2.modelo = 12455;
        carro2.placa = 124515;
        
        
        System.out.println(carro1.cor);
        System.out.print(carro1.marca);
        
        System.out.println(carro2.cor);
        System.out.println(carro2.marca);
    }
    
   
    
}
