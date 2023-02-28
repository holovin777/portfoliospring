package ninja.curriculum.portfoliospring.educationalinstitution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/educational-institution")
public class EducationInstitutionController {
    private final EducationalInstitutionService educationalInstitutionService;

    @Autowired
    public EducationInstitutionController(EducationalInstitutionService educationalInstitutionService) {
        this.educationalInstitutionService = educationalInstitutionService;
    }

    @GetMapping(path = "all")
    public List<EducationalInstitution> getEducationalInstitutions() {
        return this.educationalInstitutionService.getEducationalInstitutions();
    }

    @PostMapping
    public void addEducationalInstitution(@RequestBody EducationalInstitution educationalInstitution) {
        this.educationalInstitutionService.addEducationalInstitution(educationalInstitution);
    }

    @DeleteMapping(path = "{educationalInstitutionId}")
    public void removeEducationalInstitution(@PathVariable Long educationalInstitutionId) {
        this.educationalInstitutionService.removeEducationalInstitution(educationalInstitutionId);
    }

    @PutMapping(path = "{educationalInstitutionId}")
    public void updateEducationalInsistution(@PathVariable Long educationalInstitutionId, @RequestParam(required = false) String nameItaly) {
        this.educationalInstitutionService.updateEducationalInstitution(educationalInstitutionId, nameItaly);
    }
}
