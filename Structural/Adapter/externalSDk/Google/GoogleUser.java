package Structural.Adapter.externalSDk.Google;

public class GoogleUser {
    String name;
    String gmail;

    GoogleUser(String name, String gmail){
        this.name = name;
        this.gmail = gmail;
    }

    public String to_String(){
        return name + " " + gmail;
    }

    public String get_name(){
        return name;
    }

    public String get_gmail(){
        return gmail;
    }
}
