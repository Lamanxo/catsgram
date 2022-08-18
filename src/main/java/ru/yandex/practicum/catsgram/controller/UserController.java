package ru.yandex.practicum.catsgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.exception.InvalidEmailException;
import ru.yandex.practicum.catsgram.exception.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;
import ru.yandex.practicum.catsgram.service.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class UserController {

    private UserService us = new UserService();

    @Autowired
    public UserController(UserService userService) {
        this.us = userService;
    }

    @GetMapping("/users")
    public Set<User> findUsers() {

        return us.findUsers();
    }

    @PostMapping(value = "/users")
    public User createUser (@RequestBody User user) {
        return us.createUser(user);
    }

    @PutMapping(value = "/users")
    public User updateUser(@RequestBody User user) {
        return us.updateUser(user);
    }



}
