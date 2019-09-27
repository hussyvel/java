public class Fatorial{   
   public static void main(String[] args)
   {
       Fatorial fatorial = new Fatorial();
       double dado = 5.0;
       dado = fatorial.fatorar(dado);

       System.out.print(dado);
   }

   public double fatorar(double fat)
   {
       if (fat < 2)
       {
           return 1;
       }else
       {
           return fat *  fatorar(fat-1);
       }
   }
}
