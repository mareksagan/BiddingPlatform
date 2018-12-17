package com.biddingplatform.db.repositories;

import com.biddingplatform.db.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    List<ClientEntity> findAll();
    Optional<ClientEntity> findById(Long aLong);
    <S extends ClientEntity> S save(S s);
}
