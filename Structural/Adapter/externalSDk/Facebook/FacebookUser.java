package Structural.Adapter.externalSDk.Facebook;

public class FacebookUser{
    String uid_name;
    String email;

    FacebookUser(String name, String email){
        this.uid_name = name;
        this.email = email;
    }

    public String to_String(){
        return uid_name + " " + email;
    }

    public String get_uid_name(){
        return uid_name;
    }

    public String get_email(){
        return get_email();
    }
}