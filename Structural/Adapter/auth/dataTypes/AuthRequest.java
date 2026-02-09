package Structural.Adapter.auth.dataTypes;

public class AuthRequest {
    private final String token;

    public AuthRequest(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
