package com.biddingplatform.db.repositories;

import com.biddingplatform.db.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    ArrayList<UserEntity> findAll();
    Optional<UserEntity> findById(UUID id);
    Optional<UserEntity> findByEmail(String email);
    ArrayList<UserEntity> findByFirstNameOrLastName(String firstName, String lastName);
    UserEntity saveAndFlush(UserEntity client);
    void deleteById(UUID uuid);
    long count();
}
