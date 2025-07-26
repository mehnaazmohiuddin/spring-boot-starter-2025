package com.ecommerce.spring_boot.controller;



import com.ecommerce.spring_boot.authentication.AuthenticationService;
import com.ecommerce.spring_boot.config.security.config.JwtUtil;
import model.LoginRequest;
import model.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    AuthenticationService authenticationService;
    JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) throws Exception {
        System.out.println("Came here in login");
      LoginResponse loginResponse=
              authenticationService.authenticate(request);
      return ResponseEntity.ok(loginResponse);
    }

    @GetMapping("/")
    public String index() {

        return "Greetings from Spring Boot!";
    }

}