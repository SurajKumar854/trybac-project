package com.trybac.learn.services;

import com.trybac.learn.entities.Driver;
import com.trybac.learn.models.APIResponse;

import java.util.List;

public interface DriverService {
    Driver register(Driver driver);

    APIResponse save(Driver driver);

    List<Driver> getDrivers();

    Driver get(int driverId);

    APIResponse deletedDriver(String email);

}
