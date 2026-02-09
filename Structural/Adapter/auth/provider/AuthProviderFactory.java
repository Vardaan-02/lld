package Structural.Adapter.auth.provider;

import java.util.Map;

import javax.management.RuntimeErrorException;

public class AuthProviderFactory{
    private final Map<AuthProviderType, AuthProvider> providers;

    public AuthProviderFactory(Map<AuthProviderType, AuthProvider> providers){
        this.providers = providers;
    }

    public AuthProvider get_provider(AuthProviderType key){
        AuthProvider provider = providers.get(key);

        if (provider == null) throw new RuntimeErrorException(null);

        return provider;
    }
}
