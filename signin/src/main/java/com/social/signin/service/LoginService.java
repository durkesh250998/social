package com.social.signin.service;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.social.signin.dto.LoginDto;
import com.social.signin.entity.LoginEntity;
import com.social.signin.repository.LoginUserRepository;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Service

public class LoginService {
    @Autowired private LoginUserRepository loginUserRepository;
    //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String LoginauthService(LoginDto logindto){
        LoginEntity loginentity = new LoginEntity();
        loginentity.setEmail(logindto.getEmail());
        loginentity.setPassword(logindto.getPassword());
        return loginUserRepository.findByEmail(loginentity.getEmail())
                .map(existingUser -> {
                    if (loginentity.getPassword().equals(existingUser.getPassword())){
                        return "Login Successful";
                    } else {
                        return "Invalid Password";
                    }
                })
                .orElse("User Not Found");
    }
}