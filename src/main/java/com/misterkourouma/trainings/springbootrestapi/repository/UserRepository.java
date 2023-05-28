package com.misterkourouma.trainings.springbootrestapi.repository;

import com.misterkourouma.trainings.springbootrestapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
