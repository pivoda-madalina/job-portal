package ro.ddroidd.jobportal.model.entity.dto.jobListing;

import java.util.UUID;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class JobListingRequestDto {
  private UUID employerId;
  private String title;
  private String description;
}
