package ra.demo_login_logout.entity;

import javax.validation.constraints.NotEmpty;

public class User {
    @NotEmpty(message = "Chưa nhập username")
    private String username;
    @NotEmpty(message = "Chưa nhập password")
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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
}
