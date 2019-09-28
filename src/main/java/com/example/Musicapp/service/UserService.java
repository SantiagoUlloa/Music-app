package com.example.Musicapp.service;

import com.example.Musicapp.models.User;
import org.springframework.http.HttpStatus;

public interface UserService {

    public User getUser(String username);

    public Iterable<User> listUsers();

    public User createUser(User newUser);

    public User login(String username, String password);

    public HttpStatus deleteById(Long userId);

    public User addSong(String username, int songId);
}
