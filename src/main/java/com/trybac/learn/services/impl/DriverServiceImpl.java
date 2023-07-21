package com.trybac.learn.services.impl;

import com.trybac.learn.entities.Driver;
import com.trybac.learn.models.APIResponse;
import com.trybac.learn.repositories.DriverRep;
import com.trybac.learn.services.DriverService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRep driverRep;

    public DriverServiceImpl(DriverRep driverRep) {
        this.driverRep = driverRep;
    }

    @Override
    public Driver register(Driver driver) {
        return this.driverRep.save(driver);
    }

    @Override
    public List<Driver> getDrivers() {
        return this.driverRep.findAll();
    }

    @Override
    public Driver get(int driverId) {
        return this.driverRep.findById(driverId).orElseThrow(() -> new RuntimeException("Driver not Found"));

    }

    @Override
    public APIResponse deletedDriver(String email) {
        if (this.driverRep.findDriverByEmail(email).isPresent()) {
            this.driverRep.delete(this.driverRep.findDriverByEmail(email).get());
            return new APIResponse(true, 200, "Successfully Deleted");
        }
        return new APIResponse(false, 500, "Error Occurred");

    }
}
