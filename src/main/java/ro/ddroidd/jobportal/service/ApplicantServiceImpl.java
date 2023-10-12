package ro.ddroidd.jobportal.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.ddroidd.jobportal.model.converter.ApplicantConverter;
import ro.ddroidd.jobportal.model.entity.dto.applicant.ApplicantRequestDto;
import ro.ddroidd.jobportal.repository.ApplicantRepository;

@Service
@AllArgsConstructor
public class ApplicantServiceImpl implements ApplicantService {

  private final ApplicantRepository applicantRepository;
  private final JobListingService jobListingService;
  private final ApplicantConverter applicantConverter;

  @Override
  public void createApplicant(ApplicantRequestDto request) {
    var jobListing = jobListingService.getJobListingById(request.getJobListing());

    var entity = applicantConverter.toApplicantEntity(request);
    entity.getJobsApplied().add(jobListing);

    applicantRepository.save(entity);
  }
}
