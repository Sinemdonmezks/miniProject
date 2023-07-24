package com.example.ksdproject.repository;

import com.example.ksdproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> , JpaSpecificationExecutor<User> {

   Optional<User> findByEmailAndPassword(String email , String password);
}
