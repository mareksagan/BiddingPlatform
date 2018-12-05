package db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {
    List<DoctorEntity> findAll();
    Optional<DoctorEntity> findById(Long aLong);
    <S extends DoctorEntity> S save(S s);
}
