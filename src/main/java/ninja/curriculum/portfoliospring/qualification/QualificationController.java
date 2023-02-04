package ninja.curriculum.portfoliospring.qualification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/qualification")
public class QualificationController {
    private final QualificationService qualificationService;

    @Autowired
    public QualificationController(QualificationService qualificationService) {
        this.qualificationService = qualificationService;
    }

    @PostMapping
    public void addQualification(@RequestBody Qualification qualification) {
        qualificationService.addQualification(qualification);
    }

    @PutMapping(path = "{qualificationId}")
    public void updateQualification(@PathVariable Long qualificationId, @RequestParam(required = false) UUID customerId, @RequestParam(required = false) Long educationalInstitutionId, @RequestParam(required = false) AcademicDegree academicDegree, @RequestParam(required = false) String faculty, @RequestParam(required = false) String department, @RequestParam(required = false) String speciality, LocalDate finishedStudying) {
        this.qualificationService.updateQualification(qualificationId, customerId, educationalInstitutionId, academicDegree, faculty, department, finishedStudying);
    }
}
