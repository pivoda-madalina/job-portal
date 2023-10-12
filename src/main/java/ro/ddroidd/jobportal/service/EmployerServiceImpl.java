package ro.ddroidd.jobportal.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.ddroidd.jobportal.model.converter.EmployerConverter;
import ro.ddroidd.jobportal.model.converter.JobListingConverter;
import ro.ddroidd.jobportal.model.entity.EmployerEntity;
import ro.ddroidd.jobportal.model.entity.dto.employer.EmployerRequestDto;
import ro.ddroidd.jobportal.model.entity.dto.jobListing.JobListingListResponseDto;
import ro.ddroidd.jobportal.repository.EmployerRepository;

@Service
@AllArgsConstructor
public class EmployerServiceImpl implements EmployerService {

  private final EmployerRepository employerRepository;
  private final EmployerConverter employerConverter;
  private final JobListingConverter jobListingConverter;

  @Override
  public void create(EmployerRequestDto request) {
    var entity = employerConverter.toEmployerEntity(request);
    employerRepository.save(entity);
  }

  @Override
  public EmployerEntity getEmployerById(UUID id) {
    return employerRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Employer with given id not found" + id));
  }

  @Override
  public JobListingListResponseDto getJobsOfEmployer(UUID employerId) {
    var employer = getEmployerById(employerId);
    return jobListingConverter.toJobListingListResponseDto(employer.getJobs());
  }

}
