package ro.ddroidd.jobportal.model.entity.dto.jobListing;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class JobListingResponseDto {
    private UUID id;
    private String title;
    private String description;
}
