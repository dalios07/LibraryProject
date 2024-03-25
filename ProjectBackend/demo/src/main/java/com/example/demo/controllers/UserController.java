package com.example.demo.controllers;


import com.example.demo.entites.User;
import com.example.demo.entites.User;
import com.example.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private final UserService UserService;
    @GetMapping

    public Page<User> Getall(Pageable pageable)
    {

        return(UserService.findAll(pageable));

    }
    @GetMapping("/{id}")

    public User GetById(@PathVariable("id") Long id)
    {

        return(UserService.findById(id));

    }
    @GetMapping("/search")

    public Page<User> search(@RequestParam("name") String name,Pageable pageable)
    {

        return(UserService.searchUsers(name,pageable));

    }

    @PostMapping

    public User Add(@RequestBody User User)
    {

        return(UserService.addUser(User));

    }
}
