package ro.ddroidd.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ddroidd.jobportal.model.entity.EmployerEntity;

import java.util.Optional;
import java.util.UUID;

public interface EmployerRepository extends JpaRepository<EmployerEntity, UUID> {
    Optional<EmployerEntity> findByName(String name);

}
