package model;

public class Admin {

    private int id;
    private String username;
    private String password;
    private String email;
    private String authToken;
    private long tokenExpiry;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public long getTokenExpiry() {
        return tokenExpiry;
    }

    public void setTokenExpiry(long tokenExpiry) {
        this.tokenExpiry = tokenExpiry;
    }
}