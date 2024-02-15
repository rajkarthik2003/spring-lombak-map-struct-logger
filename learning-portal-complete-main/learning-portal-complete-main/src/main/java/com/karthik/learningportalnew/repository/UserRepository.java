package com.karthik.learningportalnew.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karthik.learningportalnew.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
