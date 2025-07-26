package com.ecommerce.spring_boot.unit_tests;

import com.ecommerce.spring_boot.config.security.config.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class JwtUtilTest {

//    @Autowired
//    JwtUtil jwtUtil;
//
//    @Test
//    public void  givesValidRolesTest(){
//        String token = jwtUtil.generateToken("mehnaaz_admin_00", List.of("ADMIN","READER"));
//        System.out.println(token);
//      //assertEquals( "r,,,oles".split(",").length,3);
//    }
}
