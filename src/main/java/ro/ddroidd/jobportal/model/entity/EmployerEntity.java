package ro.ddroidd.jobportal.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity(name = "employer")
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class EmployerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "employer")
    private List<JobListingEntity> jobs;

}
