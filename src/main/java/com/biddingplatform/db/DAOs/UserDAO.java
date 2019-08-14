package com.biddingplatform.db.DAOs;

import com.biddingplatform.db.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserDAO extends JpaRepository<User, UUID> {
    ArrayList<User> findAll();
    Optional<User> findById(UUID id);
    Optional<User> findByEmail(String email);
    ArrayList<User> findByFirstNameOrLastName(String firstName, String lastName);
    User saveAndFlush(User client);
    void deleteById(UUID uuid);
    long count();
}
