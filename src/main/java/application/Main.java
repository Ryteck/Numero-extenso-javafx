package application;

public class Main {

    private static Initializer init = new Initializer();

    public static void main(String[] args) {

        try {
            init.home();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
