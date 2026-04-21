package ninja.curriculum.portfoliospring.auth;

import java.util.UUID;

public class LoginResponse {

    private String token;
    private String email;
    private String role;
    private UUID customerId;

    public LoginResponse() {
    }

    public LoginResponse(String token, String email, String role, UUID customerId) {
        this.token = token;
        this.email = email;
        this.role = role;
        this.customerId = customerId;
    }

    public String getToken() {
        return token;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }
}
