package ro.ddroidd.jobportal.model.converter;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ro.ddroidd.jobportal.model.entity.JobListingEntity;
import ro.ddroidd.jobportal.model.entity.dto.jobListing.JobListingListResponseDto;
import ro.ddroidd.jobportal.model.entity.dto.jobListing.JobListingRequestDto;
import ro.ddroidd.jobportal.model.entity.dto.jobListing.JobListingResponseDto;

@Component
@AllArgsConstructor
public class JobListingConverter {

  public JobListingEntity toJobListingEntity(JobListingRequestDto request) {
    return JobListingEntity.builder()
        .title(request.getTitle())
        .description(request.getDescription())
        .build();
  }

  public JobListingListResponseDto toJobListingListResponseDto(
      List<JobListingEntity> jobListingEntityList) {
    List<JobListingResponseDto> list =
        jobListingEntityList.stream().map(this::toJobListingResponseDto).toList();

    return JobListingListResponseDto.builder().jobs(list).build();
  }

  public JobListingResponseDto toJobListingResponseDto(JobListingEntity entity) {
    return JobListingResponseDto.builder()
        .id(entity.getId())
        .title(entity.getTitle())
        .description(entity.getDescription())
        .build();
  }
}
