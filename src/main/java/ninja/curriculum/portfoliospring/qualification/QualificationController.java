package ninja.curriculum.portfoliospring.qualification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/qualification")
public class QualificationController {
    private final QualificationService qualificationService;

    @Autowired
    public QualificationController(QualificationService qualificationService) {
        this.qualificationService = qualificationService;
    }

    @PostMapping
    public void addQualification(@RequestBody Qualification qualification) {
        this.qualificationService.addQualification(qualification);
    }

    @PutMapping(path = "/{qualificationId}/update")
    public void updateQualification(@PathVariable Long qualificationId,
                                    @RequestParam(required = false) UUID customerId,
                                    @RequestParam(required = false) Long educationalInstitutionId,
                                    @RequestParam(required = false) AcademicDegree academicDegree,
                                    @RequestParam(required = false) String faculty,
                                    @RequestParam(required = false) String facultyItaly,
                                    @RequestParam(required = false) String department,
                                    @RequestParam(required = false) String departmentItaly,
                                    @RequestParam(required = false) String speciality,
                                    @RequestParam(required = false) String specialityItaly,
                                    @RequestParam(required = false) LocalDate finishedStudying,
                                    @RequestParam(required = false) LocalDate startedStudying
                                    ) {
        this.qualificationService.updateQualification(
                qualificationId,
                customerId,
                educationalInstitutionId,
                academicDegree,
                faculty,
                facultyItaly,
                department,
                departmentItaly,
                speciality,
                specialityItaly,
                finishedStudying,
                startedStudying
        );
    }

    @GetMapping(path = "/all")
    public List<Qualification> getQualifications() {
        return this.qualificationService.getQualifications();
    }

    @GetMapping(path = "/all/customer/{customerId}")
    public List<Qualification> getQualificationsByCustomerId(@PathVariable UUID customerId) {
        return this.qualificationService.getQualificationsByCustomerId(customerId);
    }
}
