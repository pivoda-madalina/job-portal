package ro.ddroidd.jobportal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.ddroidd.jobportal.model.entity.dto.applicant.ApplicantRequestDto;
import ro.ddroidd.jobportal.service.ApplicantService;

@RestController
@RequestMapping("/api/applicants")
@RequiredArgsConstructor
public class ApplicantController {

  private final ApplicantService applicantService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody ApplicantRequestDto request) {
    applicantService.createApplicant(request);
  }
}
