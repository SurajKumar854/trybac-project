package com.trybac.learn;

import com.trybac.learn.services.DriverService;
import com.trybac.learn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class TrybacProjectApplication {

    @Autowired
    private DriverService driverService;
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(TrybacProjectApplication.class, args);
    }

}
