class Singleton{
    private static Singleton s;

    private Singleton(){
        if (s != null) throw new IllegalStateException("Already created");
    };

    public static Singleton getSingleton(){
        if (s == null) {
            synchronized(Singleton.class) {
                if (s == null) s = new Singleton();
            }
        }
        return s;
    }
}

public class Optimal{
    public static void main(String[] args){
        
    }
}