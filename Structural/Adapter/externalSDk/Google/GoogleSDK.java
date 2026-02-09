package Structural.Adapter.externalSDk.Google;

import javax.management.RuntimeErrorException;

public class GoogleSDK {
    public GoogleUser verifyToken(String token){
        if (token == "systUm"){
            return new GoogleUser("Vardaan", "vardaanpahwa02@gmail.com");
        }
        else throw new RuntimeErrorException(null);
    }
}
