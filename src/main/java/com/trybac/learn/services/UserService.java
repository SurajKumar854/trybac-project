package com.trybac.learn.services;

import com.trybac.learn.entities.Driver;
import com.trybac.learn.entities.User;
import com.trybac.learn.models.APIResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    User register(User user);

    List<User> getUsers();

    User getUserByEmail(String email);

    APIResponse deleteUser(String email);

}
