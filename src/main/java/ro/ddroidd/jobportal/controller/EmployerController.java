package ro.ddroidd.jobportal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.ddroidd.jobportal.model.entity.dto.employer.EmployerRequestDto;
import ro.ddroidd.jobportal.service.EmployerService;

@RestController
@RequestMapping("/api/employers")
@RequiredArgsConstructor
public class EmployerController {

  private final EmployerService employerService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody EmployerRequestDto employerRequestDto) {
    employerService.create(employerRequestDto);
  }


}
