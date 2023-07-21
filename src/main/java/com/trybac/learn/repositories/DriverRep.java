package com.trybac.learn.repositories;

import com.trybac.learn.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRep extends JpaRepository<Driver, Integer> {
    @Query("Select s FROM Driver s Where s.email= ?1")
    Optional<Driver> findDriverByEmail(String email);

    @Modifying
    @Query("delete FROM Driver d  Where d.email= :email")
    void deleteDriver(@Param("email") String email);

}
