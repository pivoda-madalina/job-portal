package ro.ddroidd.jobportal.controller;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.ddroidd.jobportal.model.entity.dto.jobListing.JobListingRequestDto;
import ro.ddroidd.jobportal.service.JobListingService;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobListingController {

  private final JobListingService jobListingServiceImpl;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody JobListingRequestDto request) {
    jobListingServiceImpl.create(request);
  }

  @DeleteMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) {
    jobListingServiceImpl.delete(id);
  }
}
