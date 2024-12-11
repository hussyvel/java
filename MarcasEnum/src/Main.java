public class Main {
    public enum MarcasEnum{
        AMAZON, DELL, HP, TOSHIBA, LG, SAMSUNG;
    }


    public static void main(String[] args) {
        MarcasEnum hp = MarcasEnum.HP;
        MarcasEnum amazon = MarcasEnum.AMAZON;
        MarcasEnum dell = MarcasEnum.DELL;
        MarcasEnum toshiba = MarcasEnum.TOSHIBA;
        MarcasEnum lg = MarcasEnum.LG;
        MarcasEnum samsung = MarcasEnum.SAMSUNG;

        System.out.println(hp.name());
        System.out.println(amazon.name());
        System.out.println(dell.name());
        System.out.println(toshiba.name());
        System.out.println(lg.name());
        System.out.println(samsung.name());
    }
}