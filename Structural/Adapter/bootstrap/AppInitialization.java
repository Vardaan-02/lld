package Structural.Adapter.bootstrap;

import java.util.HashMap;
import java.util.Map;

import Structural.Adapter.auth.AuthenticationService;
import Structural.Adapter.auth.adapters.FacebookAdapter;
import Structural.Adapter.auth.adapters.GoogleAdapter;
import Structural.Adapter.auth.provider.AuthProvider;
import Structural.Adapter.auth.provider.AuthProviderFactory;
import Structural.Adapter.auth.provider.AuthProviderType;
import Structural.Adapter.externalSDk.Facebook.FacebookSDK;
import Structural.Adapter.externalSDk.Google.GoogleSDK;

public class AppInitialization {
    public static AuthenticationService init(){
        AuthProvider google = new GoogleAdapter(new GoogleSDK());

        AuthProvider facebook = new FacebookAdapter(new FacebookSDK());

        Map<AuthProviderType, AuthProvider> providers = new HashMap<>();

        providers.put(AuthProviderType.GOOGLE, google);
        providers.put(AuthProviderType.FACEBOOK, facebook);

        AuthProviderFactory factory = new AuthProviderFactory(providers);

        return new AuthenticationService(factory);
    }
}
