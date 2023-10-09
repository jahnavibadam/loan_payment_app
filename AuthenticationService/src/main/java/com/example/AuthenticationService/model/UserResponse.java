package AuthenticationService.src.main.java.com.example.AuthenticationService.model;

public class UserResponse {
    private final String token;

    public UserResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
