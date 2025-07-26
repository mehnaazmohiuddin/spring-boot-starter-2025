package model;

import lombok.Data;

import java.util.List;
@Data
public class LoginResponse  {
    String userName;
    private List<String> roles;
    String tokenType;
    String token;
    public LoginResponse(){
    }
    public LoginResponse(List<String> roles, String userName, String tokenType, String token) {
        this.roles = roles;
        this.userName = userName;
        this.tokenType = tokenType;
        this.token = token;
    }

}
