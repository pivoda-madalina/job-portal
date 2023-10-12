package ro.ddroidd.jobportal.model.converter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ro.ddroidd.jobportal.model.entity.EmployerEntity;
import ro.ddroidd.jobportal.model.entity.dto.employer.EmployerRequestDto;

@Component
@AllArgsConstructor
public class EmployerConverter {

  public EmployerEntity toEmployerEntity(EmployerRequestDto request) {
    return EmployerEntity.builder().name(request.getName()).build();
  }
}
