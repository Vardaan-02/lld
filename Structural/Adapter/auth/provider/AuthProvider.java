package Structural.Adapter.auth.provider;

import Structural.Adapter.auth.dataTypes.AuthRequest;
import Structural.Adapter.auth.dataTypes.AuthResult;

public interface AuthProvider {
    AuthResult authenticate(AuthRequest request);
}
