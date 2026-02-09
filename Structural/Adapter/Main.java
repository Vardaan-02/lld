package Structural.Adapter;

import Structural.Adapter.auth.AuthenticationService;
import Structural.Adapter.auth.dataTypes.AuthResult;
import Structural.Adapter.auth.provider.AuthProviderType;
import Structural.Adapter.bootstrap.AppInitialization;

public class Main {

    public static void main(String[] args){
        AuthenticationService authService = AppInitialization.init();

        AuthResult res = authService.login(AuthProviderType.GOOGLE, "systUm");

        System.out.println(res);
    }
}
