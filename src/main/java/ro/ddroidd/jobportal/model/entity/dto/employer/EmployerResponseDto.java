package ro.ddroidd.jobportal.model.entity.dto.employer;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class EmployerResponseDto {
    private UUID id;
    private String name;
}
