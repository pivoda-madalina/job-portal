package ro.ddroidd.jobportal.controller;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.ddroidd.jobportal.model.entity.dto.jobListing.JobListingListResponseDto;
import ro.ddroidd.jobportal.service.EmployerService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class JobPortalController {

  private final EmployerService employerService;

  @GetMapping(value = "/employers/{employerId}/jobs")
  @ResponseStatus(HttpStatus.OK)
  public JobListingListResponseDto getEmployerJobs(@PathVariable UUID employerId) {
    return employerService.getJobsOfEmployer(employerId);
  }
}
