package com.biddingplatform.db.repositories;

import com.biddingplatform.db.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CountryRepository extends JpaRepository<Country, UUID> {
    Optional<Country> findById(UUID id);
    Optional<Country> findByName(String name);
}
