package ro.ddroidd.jobportal.service;

import ro.ddroidd.jobportal.model.entity.dto.applicant.ApplicantRequestDto;

public interface ApplicantService {
    void createApplicant(ApplicantRequestDto request);
}
