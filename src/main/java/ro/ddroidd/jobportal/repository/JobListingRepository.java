package ro.ddroidd.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.ddroidd.jobportal.model.entity.JobListingEntity;

import java.util.List;
import java.util.UUID;

public interface JobListingRepository extends JpaRepository<JobListingEntity, UUID> {
    List<JobListingEntity> findByTitle(String title);

//    @Query("SELECT i FROM job i JOIN i.employer e WHERE e.id=:employerId")
//    List<JobListingEntity> getAllJobsByEmployer(@Param("employerId") UUID employerId);
}
