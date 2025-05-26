package com.social.signin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.social.signin.entity.SignupEntity;

@Repository
public interface SignupUserRepository extends JpaRepository<SignupEntity, Long> {
}
