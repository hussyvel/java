public class Main {
    public static void main(String[] args){

      String[] vector = new String[] {"João", "Maria", "Ethan"};

      for (int i = 0; i < vector.length; i++){
          System.out.println(vector[i]);
      }

      System.out.println("--------------------");
      for (String x : vector){
          System.out.println(x);
      }
    }
}