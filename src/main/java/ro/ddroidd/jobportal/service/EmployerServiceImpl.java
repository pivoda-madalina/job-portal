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

  //    public void create(EmployerRequestDto employerRequestDto) {
  //
  //        if (employerExists(employerRequestDto.getName())) {
  //            throw new RuntimeException("Employer already exists!");
  //        }
  //
  //        EmployerEntity employerEntity = EmployerEntity.builder()
  //                .name(employerRequestDto.getName())
  //                .build();
  //
  //        employerRepository.save(employerEntity);
  //    }
  //
  //    private boolean employerExists(String name) {
  //        return employerRepository.findByName(name).isPresent();
  //    }
  //
  //    public List<EmployerResponseDto> getAll(List<EmployerEntity> employerEntityList) {
  //        List<EmployerResponseDto> employerDtoList = new ArrayList<>();
  //        for (EmployerEntity employerEntity : employerEntityList) {
  //            EmployerResponseDto employerDto = EmployerResponseDto.builder()
  //                    .id(employerEntity.getId())
  //                    .name(employerEntity.getName())
  //                    .build();
  //            employerDtoList.add(employerDto);
  //        }
  //        return employerDtoList;
  //    }
  //
  //    public void addJobListing(List<EmployerEntity> employerEntityList) {
  //
  //        for (EmployerEntity employerEntity:employerEntityList) {
  //            JobListingEntity jobListing = jobListingService.create(new JobListingRequestDto());
  //            employerEntity.getJobs().add(jobListing);
  //        }
  //
  //    }
}
