package singleton;

public class Singleton {
    int num = 0;
    private Singleton(){
    }

    private static Singleton instance;

    public static  Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
