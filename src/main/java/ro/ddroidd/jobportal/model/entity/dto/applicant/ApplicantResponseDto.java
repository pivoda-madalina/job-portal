package ro.ddroidd.jobportal.model.entity.dto.applicant;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ApplicantResponseDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNr;
    private String addressLine1;
    private String addressLine2;
    private String country;
    private String state;
    private String city;
}
