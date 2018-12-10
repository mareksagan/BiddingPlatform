package db.repositories;

import db.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    List<ClientEntity> findAll();
    Optional<ClientEntity> findById(Long aLong);
    <S extends ClientEntity> S save(S s);
}
