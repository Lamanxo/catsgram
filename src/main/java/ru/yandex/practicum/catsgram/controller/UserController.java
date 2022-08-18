package ru.yandex.practicum.catsgram.controller;

import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.exception.InvalidEmailException;
import ru.yandex.practicum.catsgram.exception.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class UserController {

    private final Set<User> users = new HashSet<>();

    @GetMapping("/users")
    public Set<User> findUsers() {
        return users;
    }

    @PostMapping(value = "/users")
    public User createUser (@RequestBody User user) {
        for (User userSet : users) {
            if (userSet.getEmail().equals(user.getEmail())) {
                final UserAlreadyExistException ex = new UserAlreadyExistException("Email already exist");
                System.out.println(ex.getMessage());
            }
        }
        if (user.getEmail() == null) {
            final InvalidEmailException ex = new InvalidEmailException("Email line is null");
            System.out.println(ex.getMessage());
        } else {
            users.add(user);
        }
        return user;
    }

    @PutMapping(value = "/users")
    public User updateUser(@RequestBody User user) {
        for (User userSet : users) {
            if (userSet.getEmail().equals(user.getEmail())) {
                users.remove(userSet);
                users.add(user);
            }
        }
        if (user.getEmail() == null) {
            final InvalidEmailException ex = new InvalidEmailException("Email line is null");
            System.out.println(ex.getMessage());
        } else {
            users.add(user);
        }
        return user;
    }



}
