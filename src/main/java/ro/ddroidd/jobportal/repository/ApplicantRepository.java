package ro.ddroidd.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ddroidd.jobportal.model.entity.ApplicantEntity;

import java.util.Optional;
import java.util.UUID;

public interface ApplicantRepository extends JpaRepository<ApplicantEntity, UUID> {
    Optional<ApplicantEntity> findByEmail(String email);
}
