package Structural.Adapter.auth.adapters;

import Structural.Adapter.auth.dataTypes.AuthRequest;
import Structural.Adapter.auth.dataTypes.AuthResult;
import Structural.Adapter.auth.provider.AuthProvider;
import Structural.Adapter.externalSDk.Google.GoogleSDK;
import Structural.Adapter.externalSDk.Google.GoogleUser;

public class GoogleAdapter implements AuthProvider{
    private GoogleSDK googleSDK;

    public GoogleAdapter(GoogleSDK googleSDK){
        this.googleSDK = googleSDK;
    }

    @Override
    public AuthResult authenticate(AuthRequest authRequest){
        GoogleUser user = googleSDK.verifyToken(authRequest.getToken());

        return new AuthResult(true, user.get_name(), user.get_gmail());
    }
}
