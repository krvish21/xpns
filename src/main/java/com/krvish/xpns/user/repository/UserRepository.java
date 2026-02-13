package com.krvish.xpns.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krvish.xpns.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
