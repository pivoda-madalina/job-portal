package ro.ddroidd.jobportal.model.entity.dto.applicant;

import lombok.Data;

import java.util.UUID;

@Data
public class ApplicantRequestDto {
    private UUID JobListing;
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
