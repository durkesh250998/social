package com.social.signin.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.signin.dto.LoginDto;
import com.social.signin.dto.SignupDto;
import com.social.signin.service.AuthService;
import com.social.signin.service.EmailKafkaProducer;
import com.social.signin.service.LoginService;


@RestController
@RequestMapping("/user")
public class Usercontroller {

    @Autowired
    private AuthService authService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private EmailKafkaProducer EmailKafkaProducer;

@PostMapping("/auth/signup")
public String SignupController(@RequestBody SignupDto signupdto){
    String result = authService.SignupAuthService(signupdto); 
     if(result.equalsIgnoreCase("success")){
        EmailKafkaProducer.sendEmail(signupdto.getEmail());
        return "Signup Successful";
    } else {
        return "Signup Failed";
    }
}

@GetMapping("/auth/login")
public String LoginController(@RequestBody LoginDto logindto) {
    return loginService.LoginauthService(logindto);
}

}
