public class Main {
    public static void main(String[] args) {

            SemConstrutor semConstrutor = new SemConstrutor();
            System.out.println(semConstrutor.descricao);

            ComConstrutor error = new ComConstrutor("definindo manualmente");
            ComConstrutor comConstrutor = new ComConstrutor("definindo manualmente");
            System.out.println(comConstrutor.descricao);
    }

}