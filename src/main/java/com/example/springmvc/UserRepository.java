package com.example.springmvc;

import com.example.springmvc.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    static List<User> users = new ArrayList<User>();

    void createUser(User user) {
        users.add(user);
    }

    User find(String userName) {
        return users.stream().filter(user -> userName.equals(user.getName())).findAny().orElse(null);
    }

    void delete(String userName) {
        User tempUser = users.stream().filter(user -> userName.equals(user.getName())).findAny().orElse(null);
        users.remove(tempUser);
        return;
    }
}
