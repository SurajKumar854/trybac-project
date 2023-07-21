package com.trybac.learn.repositories;

import com.trybac.learn.entities.Driver;
import com.trybac.learn.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRep extends JpaRepository<User, Integer> {
    @Query("Select s FROM User s Where s.email= ?1")
    Optional<User> findUserByEmail(String email);

    @Modifying
    @Query("delete FROM User d  Where d.email= :email")
    void deleteUser(@Param("email") String email);

}
