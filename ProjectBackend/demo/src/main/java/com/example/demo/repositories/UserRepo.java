package com.example.demo.repositories;

import com.example.demo.Enums.Role;
import com.example.demo.entites.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByName(String username);


    Page<User> findByRole(Role role, Pageable pageable);


    Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
