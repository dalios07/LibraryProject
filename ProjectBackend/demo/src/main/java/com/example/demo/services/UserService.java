package com.example.demo.services;

import com.example.demo.entites.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User findById(Long id);

    Page<User> findAll(Pageable pageable);



    Page<User> searchUsers(String name, Pageable pageable);

    User addUser(User User);
}
