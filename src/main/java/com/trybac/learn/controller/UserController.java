package com.trybac.learn.controller;

import com.trybac.learn.entities.User;
import com.trybac.learn.models.APIResponse;

import com.trybac.learn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @MutationMapping("registerUser")
    public User register(@Argument UserInput user) {

        System.out.println(user.name);
        User mUser = new User();
        mUser.setName(user.getName());
        mUser.setAge(user.getAge());
        mUser.setEmail(user.getEmail());
        mUser.setMobile(user.getMobile());
        mUser.setPassword(user.getPassword());
        return this.userService.register(mUser);
    }

    @QueryMapping("getUsers")
    public List<User> getAll() {
        return this.userService.getUsers();
    }

    @QueryMapping("getUserByEmail")
    public User getUserByEmail(@Argument String email) {
        return this.userService.getUserByEmail(email);
    }

    @MutationMapping("deleteUserByEmail")
    public APIResponse deleteUser(@Argument String email) {
        return this.userService.deleteUser(email);
    }


    public class UserInput {
        private String name;
        private int age;
        private String mobile;
        private String email;
        private String password;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public UserInput(String name, int age, String mobile, String email, String password) {
            this.name = name;
            this.age = age;
            this.mobile = mobile;
            this.email = email;
            this.password = password;
        }
    }
}
