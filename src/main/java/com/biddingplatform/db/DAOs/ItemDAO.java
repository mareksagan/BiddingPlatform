package com.biddingplatform.db.DAOs;

import com.biddingplatform.db.entities.User;
import com.biddingplatform.db.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ItemDAO extends JpaRepository<Item, UUID> {
    ArrayList<Item> findAll();
    Optional<Item> findById(UUID id);
    User saveAndFlush(User client);
    void deleteById(UUID uuid);
    long count();
}
