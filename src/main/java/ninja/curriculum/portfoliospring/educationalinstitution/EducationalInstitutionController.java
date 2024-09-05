package ninja.curriculum.portfoliospring.educationalinstitution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/educational-institution")
public class EducationalInstitutionController {
    private final EducationalInstitutionService educationalInstitutionService;

    @Autowired
    public EducationalInstitutionController(EducationalInstitutionService educationalInstitutionService) {
        this.educationalInstitutionService = educationalInstitutionService;
    }

    @GetMapping(path = "/all")
    public List<EducationalInstitution> getEducationalInstitutions() {
        return this.educationalInstitutionService.getEducationalInstitutions();
    }

    @PostMapping
    public void addEducationalInstitution(@RequestBody EducationalInstitution educationalInstitution) {
        this.educationalInstitutionService.addEducationalInstitution(educationalInstitution);
    }

    @DeleteMapping(path = "/{educationalInstitutionId}/delete")
    public void removeEducationalInstitution(@PathVariable Long educationalInstitutionId) {
        this.educationalInstitutionService.removeEducationalInstitution(educationalInstitutionId);
    }

    @PutMapping(path = "/{educationalInstitutionId}/update")
    public void updateEducationalInstitution(@PathVariable Long educationalInstitutionId,
                                             @RequestParam(required = false) String nameIt,
                                             @RequestParam(required = false) String location,
                                             @RequestParam(required = false) String locationIt,
                                             @RequestParam(required = false) StudyPlace studyPlace
    ) {
        this.educationalInstitutionService.updateEducationalInstitution(educationalInstitutionId, nameIt, location, locationIt, studyPlace);
    }
}
