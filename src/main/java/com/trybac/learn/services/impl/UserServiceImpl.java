package com.trybac.learn.services.impl;

import com.trybac.learn.entities.User;
import com.trybac.learn.models.APIResponse;
import com.trybac.learn.repositories.UserRep;
import com.trybac.learn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRep userRep;

    @Override
    public User register(User user) {
        return userRep.save(user);
    }

    @Override
    public List<User> getUsers() {
        return this.userRep.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return this.userRep.findUserByEmail(email).get();
    }


    @Override
    public APIResponse deleteUser(String email) {
        if (this.userRep.findUserByEmail(email).isPresent()) {
            this.userRep.delete(this.userRep.findUserByEmail(email).get());
            return new APIResponse(true, 200, "Successfully Deleted");
        }
        return new APIResponse(false, 500, "Error Occurred");
    }
}
