package ru.yandex.practicum.catsgram.service;

import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.exception.InvalidEmailException;
import ru.yandex.practicum.catsgram.exception.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class UserService {

    Set<User> users = new HashSet<>();

    public Set<User> findUsers() {
        return users;
    }

    public User createUser(User user) {
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

    public User updateUser (User user) {
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

    public User findUserByEmail (String email) {
        for (User us : users) {
            if (us.getEmail().equals(email)) {
                return us;
            }
        }
        return null;
    }
}
