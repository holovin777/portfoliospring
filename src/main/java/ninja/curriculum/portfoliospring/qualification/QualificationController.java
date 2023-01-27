package ninja.curriculum.portfoliospring.qualification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
