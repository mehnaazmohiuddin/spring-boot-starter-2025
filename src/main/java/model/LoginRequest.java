package model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginRequest implements AuthRequest{
    @JsonProperty("username")
    String userName;
    String password;

}
