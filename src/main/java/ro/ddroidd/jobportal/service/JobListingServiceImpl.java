package ro.ddroidd.jobportal.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.ddroidd.jobportal.model.converter.JobListingConverter;
import ro.ddroidd.jobportal.model.entity.JobListingEntity;
import ro.ddroidd.jobportal.model.entity.dto.jobListing.JobListingRequestDto;
import ro.ddroidd.jobportal.repository.JobListingRepository;

@Service
@AllArgsConstructor
public class JobListingServiceImpl implements JobListingService {

  private final JobListingRepository jobListingRepository;
  private final EmployerService employerService;
  private final JobListingConverter jobListingConverter;

  @Override
  public void create(JobListingRequestDto requestDto) {
    var employer = employerService.getEmployerById(requestDto.getEmployerId());

    var entity = jobListingConverter.toJobListingEntity(requestDto);
    entity.setEmployer(employer);

    jobListingRepository.save(entity);
  }

  @Override
  public void delete(UUID id) {
    var entity = getJobListingById(id);
    jobListingRepository.delete(entity);
  }

  @Override
  public JobListingEntity getJobListingById(UUID id) {
    return jobListingRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Job listing with given id not found" + id));
  }
}
