package com.social.signin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.social.signin.repository")
@EntityScan(basePackages = "com.social.signin.entity")
public class SigninApplication {

	public static void main(String[] args) {
		SpringApplication.run(SigninApplication.class, args);
	}

}
