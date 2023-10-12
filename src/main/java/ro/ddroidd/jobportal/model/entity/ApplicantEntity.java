package ro.ddroidd.jobportal.model.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.*;

@Entity(name = "applicant")
@Table(name = "applicants")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ApplicantEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  @Column(name = "phone_nr")
  private String phoneNr;

  @Column(name = "address_line_1")
  private String addressLine1;

  @Column(name = "address_line_2")
  private String addressLine2;

  @Column(name = "country")
  private String country;

  @Column(name = "state")
  private String state;

  @Column(name = "city")
  private String city;

  @ManyToMany(cascade = CascadeType.ALL, mappedBy = "applicants")
  private List<JobListingEntity> jobsApplied = new ArrayList<>();
}
