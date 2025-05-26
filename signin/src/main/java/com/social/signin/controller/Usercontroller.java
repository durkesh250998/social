package com.social.signin.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.social.signin.dto.SignupDto;
import com.social.signin.service.AuthService;

@RestController
@RequestMapping("/user")
public class Usercontroller {

    @Autowired
    private AuthService authService;

@PostMapping("/auth/signup")
public String SignupController(@RequestBody SignupDto signupdto){
    return authService.LoginAuthService(signupdto); 
}
}
