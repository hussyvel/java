import javax.swing.*;

class Palindrome{  

public static void main(String[] args) {
       
       String palavra, palavraInvertida="";
       int tamanho,i;


       // Armazena a palavra numa String
       palavra = JOptionPane.showInputDialog(null,"Digite uma palavra"); 


       //tamanho recebe o qtd de letras q possui a palavra
       tamanho=palavra.length(); 
       
       
       //pega a ultima letra da variavel palavra, e inseri na primeira de palavraInvertida, depois pega penultima e inseri na 2ª, e assim em diante, até pegar a primeira, e colocar na ultima.
       for(i=tamanho-1;i>=0;i--){  
           palavraInvertida += palavra.charAt(i);
        }
        

       //Compara as Duas Strings e Exibe o Resultado
       if(palavra.equals(palavraInvertida)) 
            JOptionPane.showMessageDialog(null, "True, " + palavra + " é uma palavra palindroma"); 
       else 
            JOptionPane.showMessageDialog(null, "False " + palavra + " não é uma palavra palindroma"); 

       
}
    
}

