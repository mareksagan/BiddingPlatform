package com.biddingplatform.db.DAOs;

import com.biddingplatform.db.entities.Address;
import com.biddingplatform.db.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressDAO extends JpaRepository<Address, UUID> {
    Optional<Address> findById(UUID id);
    ArrayList<User> findByStreetOrCity(String street, String city);
    Address saveAndFlush(Address address);
    void deleteById(UUID uuid);
}
