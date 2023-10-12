package ro.ddroidd.jobportal.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity(name = "job")
@Table(name = "jobs")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class JobListingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_id")
    private EmployerEntity employer;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "job_applicant",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "applicant_id"))
    private List<ApplicantEntity> applicants;
}
