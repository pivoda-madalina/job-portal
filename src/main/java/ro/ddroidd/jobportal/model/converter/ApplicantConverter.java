package ro.ddroidd.jobportal.model.converter;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ro.ddroidd.jobportal.model.entity.ApplicantEntity;
import ro.ddroidd.jobportal.model.entity.dto.applicant.ApplicantRequestDto;

@Component
@AllArgsConstructor
public class ApplicantConverter {

  public ApplicantEntity toApplicantEntity(ApplicantRequestDto request) {
    return ApplicantEntity.builder()
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .email(request.getEmail())
        .phoneNr(request.getPhoneNr())
        .addressLine1(request.getAddressLine1())
        .addressLine2(request.getAddressLine2())
        .country(request.getCountry())
        .state(request.getState())
        .city(request.getCity())
        .jobsApplied(new ArrayList<>())
        .build();
  }
}
