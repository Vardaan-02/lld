package Structural.Adapter.auth.adapters;

import Structural.Adapter.auth.dataTypes.AuthRequest;
import Structural.Adapter.auth.dataTypes.AuthResult;
import Structural.Adapter.auth.provider.AuthProvider;
import Structural.Adapter.externalSDk.Facebook.FacebookSDK;
import Structural.Adapter.externalSDk.Facebook.FacebookUser;

public class FacebookAdapter implements AuthProvider{
    private FacebookSDK facebookSDK;

    public FacebookAdapter(FacebookSDK facebookSDK){
        this.facebookSDK = facebookSDK;
    }

    public AuthResult authenticate(AuthRequest authRequest){
        FacebookUser user = facebookSDK.validate(authRequest.getToken());

        return new AuthResult(true, user.get_uid_name(), user.get_email());
    }
}
