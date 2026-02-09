package Structural.Adapter.externalSDk.Facebook;

import javax.management.RuntimeErrorException;

public class FacebookSDK {
    public FacebookUser validate(String token){
        if (token == "systUm"){
            return new FacebookUser("Vardaan", "vardaanpahwa02@gmail.com");
        }
        else throw new RuntimeErrorException(null);
    }
}
