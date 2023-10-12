package ro.ddroidd.jobportal.service;

import java.util.UUID;
import ro.ddroidd.jobportal.model.entity.JobListingEntity;
import ro.ddroidd.jobportal.model.entity.dto.jobListing.JobListingRequestDto;

public interface JobListingService {

  void create(JobListingRequestDto requestDto);

  void delete(UUID id);

  JobListingEntity getJobListingById(UUID id);
}
