package com.social.signin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.social.signin.entity.LoginEntity;

@Repository
public interface LoginUserRepository extends JpaRepository<LoginEntity, Long> {
    java.util.Optional<LoginEntity> findByEmail(String email);
}
