package com.biddingplatform.db.repositories;

import com.biddingplatform.db.entities.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, UUID> {
    Optional<CountryEntity> findById(UUID id);
    Optional<CountryEntity> findByName(String name);
}
