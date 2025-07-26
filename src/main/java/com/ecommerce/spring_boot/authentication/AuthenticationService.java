package com.ecommerce.spring_boot.authentication;

import com.ecommerce.spring_boot.config.security.config.JwtUtil;
import model.AuthRequest;
import model.LoginRequest;
import model.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthenticationService {
    @Autowired
    JwtUtil jwtUtil;
    public LoginResponse authenticate(AuthRequest authRequest) throws Exception{
        if(authRequest instanceof LoginRequest && ((LoginRequest) authRequest).getUserName().contains("admin")){
            String accessToken = jwtUtil.generateToken(((LoginRequest) authRequest).getUserName(),List.of("READER","WRITER"));
            return new LoginResponse(List.of("ADMIN","READER","WRITER") , ((LoginRequest) authRequest).getUserName(),"Bearer",accessToken);
        }else if(! (authRequest instanceof LoginRequest)){
            throw  new Exception("Invalid Request, not supported");
        }
        else{
            throw  new SecurityException("Invalid User, we cant authenticate you");
        }

    }



}
