
import java.util.Scanner;

public class Tomada_de_decisao {

    public static void main(String[] args){
        
        
        int num;
        System.out.println("Digite o numemro: ");
        
        Scanner in = new Scanner(System.in);
        num = in.nextInt();
        
        if(num == 1){
            System.out.println("sim, é igual, que legal.");
        }else{
            System.out.println("Vixe é diferente hahahahaha");
        } 
    }
}