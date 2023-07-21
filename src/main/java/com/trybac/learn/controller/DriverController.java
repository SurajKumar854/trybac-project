package com.trybac.learn.controller;

import com.trybac.learn.entities.Driver;
import com.trybac.learn.models.APIResponse;
import com.trybac.learn.repositories.DriverRep;
import com.trybac.learn.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Controller
public class DriverController {
    @Autowired
    private DriverService driverService;
    @Autowired
    private DriverRep driverRep;

    @MutationMapping("registerDriver")
    public Driver register(@Argument DriverInput driver) {
        System.out.println(driver.name);
        Driver mdriver = new Driver();
        mdriver.setName(driver.getName());
        mdriver.setAge(driver.getAge());
        mdriver.setEmail(driver.getEmail());
        mdriver.setMobile(driver.getMobile());
        mdriver.setPassword(driver.getPassword());
        return this.driverService.register(mdriver);
    }

    @QueryMapping("getDriver")
    public List<Driver> getAll() {
        return this.driverService.getDrivers();
    }

    @QueryMapping("getDriverById")
    public Driver get(@Argument String email) {
        if (driverRep.findDriverByEmail(email).isPresent()) {
            return driverRep.findDriverByEmail(email).get();
        }
        return null;
    }

    @MutationMapping("deleteDriverByEmail")
    public APIResponse deleteDriver(@Argument String email) {
        System.out.println(email);

       return this.driverService.deletedDriver(email);
    }



   public class DriverInput {
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

        public DriverInput(String name, int age, String mobile, String email, String password) {
            this.name = name;
            this.age = age;
            this.mobile = mobile;
            this.email = email;
            this.password = password;
        }
    }
}
