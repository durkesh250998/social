package com.social.signin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.signin.dto.SignupDto;
import com.social.signin.entity.SignupEntity;
import com.social.signin.repository.SignupUserRepository;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Service
public class AuthService {
    
    @Autowired
    private SignupUserRepository signupUserRepository;
    
    public String SignupAuthService(SignupDto signupdto){
        SignupEntity signupEntity = new SignupEntity();
        signupEntity.setEmail(signupdto.getEmail());
        signupEntity.setPassword(signupdto.getPassword());
        return signupUserRepository.save(signupEntity) != null ? "success" : "failure";
       
    }
}
