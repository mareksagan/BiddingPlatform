package com.biddingplatform.db.repositories;

import com.biddingplatform.db.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, UUID> {
    ArrayList<ClientEntity> findAll();
    Optional<ClientEntity> findById(UUID id);
    ClientEntity findByEmail(String email);
    ArrayList<ClientEntity> findByFirstNameOrLastName(String firstName, String lastName);
    <S extends ClientEntity> S save(S s);
    void deleteById(UUID uuid);
    long count();
}
