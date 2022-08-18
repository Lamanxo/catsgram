package ru.yandex.practicum.catsgram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import ru.yandex.practicum.catsgram.exception.UserNotFoundException;
import ru.yandex.practicum.catsgram.model.Post;

import java.util.*;

@Service
public class PostService {

    UserService us = new UserService();

    @Autowired
    public PostService(UserService userService) {
        this.us = userService;
    }

    private final List<Post> posts = new ArrayList<>();

    public List<Post> findAll() {
        return posts;
    }

    public Post create(Post post) {
        if (us.findUserByEmail(post.getAuthor()) != null) {
            posts.add(post);
        } else {
            throw new UserNotFoundException("User " + post.getAuthor() + " not found");
        }

        return post;
    }
}
