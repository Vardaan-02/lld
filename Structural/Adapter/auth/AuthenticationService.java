package Structural.Adapter.auth;

import Structural.Adapter.auth.dataTypes.AuthRequest;
import Structural.Adapter.auth.dataTypes.AuthResult;
import Structural.Adapter.auth.provider.AuthProvider;
import Structural.Adapter.auth.provider.AuthProviderFactory;
import Structural.Adapter.auth.provider.AuthProviderType;

public class AuthenticationService {

    private final AuthProviderFactory factory;

    public AuthenticationService(AuthProviderFactory factory) {
        this.factory = factory;
    }

    public AuthResult login(AuthProviderType provider, String token) {

        AuthProvider authProvider = factory.get_provider(provider);

        return authProvider.authenticate(new AuthRequest(token)
        );
    }
}

