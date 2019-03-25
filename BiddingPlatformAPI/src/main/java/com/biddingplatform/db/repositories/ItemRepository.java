package com.biddingplatform.db.repositories;

import com.biddingplatform.db.entities.UserEntity;
import com.biddingplatform.db.entities.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, UUID> {
    ArrayList<ItemEntity> findAll();
    Optional<ItemEntity> findById(UUID id);
    UserEntity findByEmail(String email);
    ArrayList<UserEntity> findBy(String firstName, String lastName);
    UserEntity saveAndFlush(UserEntity client);
    void deleteById(UUID uuid);
    long count();
}
