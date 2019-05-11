package com.biddingplatform.db.repositories;

import com.biddingplatform.db.entities.AddressEntity;
import com.biddingplatform.db.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, UUID> {
    Optional<AddressEntity> findById(UUID id);
    ArrayList<UserEntity> findByStreetOrCity(String street, String city);
    AddressEntity saveAndFlush(AddressEntity address);
    void deleteById(UUID uuid);
}
