package com.example.demo.services;

import com.example.demo.Enums.Role;
import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.entites.User;
import com.example.demo.repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepo userRepository;
    @Override
    public User findById(Long id)
    {
        Optional<User> student= userRepository.findById(id);
        if(student.isPresent())
            return student.get();

            throw new ResourceNotFoundException("User not found with id " + id);
    }
    @Override
    public Page<User> findAll(Pageable pageable) {

        return userRepository.findByRole(Role.STUDENT,pageable);
    }

    @Override
    public Page<User> searchUsers(String name, Pageable pageable)
    {

        return  userRepository.findByNameContainingIgnoreCase(name, pageable);

    }

    @Override
    public User addUser(User User) {

        return (userRepository.save(User));
    }

}
