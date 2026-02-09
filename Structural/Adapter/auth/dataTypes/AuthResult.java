package Structural.Adapter.auth.dataTypes;

public class AuthResult {
    private final boolean success;
    private final String userId;
    private final String email;

    public AuthResult(boolean success, String userId, String email) {
        this.success = success;
        this.userId = userId;
        this.email = email;
    }

    public boolean isSuccess() { return success; }
    public String getUserId() { return userId; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "success=" + success + ", userId='" + userId + '\'' + ", email='" + email;
    }
}
