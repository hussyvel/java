public class Account {

   private String name;

   public Account(String name){
       this.name = name;
   }

    public String getName(){
       return name;
    }

    public String setName(String name){
       this.name = name;
        return name;
    }
}
