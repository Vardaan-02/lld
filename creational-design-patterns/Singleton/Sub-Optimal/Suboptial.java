class Singleton{
    private static Singleton s;

    private Singleton(){};

    public static Singleton getSingleton(){
        if (s == null){
            s = new Singleton();
        }
        return s;
    }
}

public class Suboptimal{
    public static void main(String[] args){

    }
}