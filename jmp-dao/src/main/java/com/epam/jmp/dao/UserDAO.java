package com.epam.jmp.dao;

import com.epam.jmp.dto.Subscription;
import com.epam.jmp.dto.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private final List<User> users;

    public UserDAO() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }
    public List<User> getAllUsers() {
        return users;
    }
}
