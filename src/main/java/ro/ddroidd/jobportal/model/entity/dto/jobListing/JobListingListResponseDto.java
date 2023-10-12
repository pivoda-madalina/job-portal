package ro.ddroidd.jobportal.model.entity.dto.jobListing;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobListingListResponseDto {
  private List<JobListingResponseDto> jobs;
}
