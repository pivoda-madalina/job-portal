package ro.ddroidd.jobportal.service;

import java.util.UUID;
import ro.ddroidd.jobportal.model.entity.EmployerEntity;
import ro.ddroidd.jobportal.model.entity.dto.employer.EmployerRequestDto;
import ro.ddroidd.jobportal.model.entity.dto.jobListing.JobListingListResponseDto;

public interface EmployerService {

  void create(EmployerRequestDto request);

  EmployerEntity getEmployerById(UUID id);

  JobListingListResponseDto getJobsOfEmployer(UUID employerId);

}
