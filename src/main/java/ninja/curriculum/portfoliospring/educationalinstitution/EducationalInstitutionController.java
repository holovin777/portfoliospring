package ninja.curriculum.portfoliospring.educationalinstitution;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/educational-institution")
public class EducationalInstitutionController {
	private final EducationalInstitutionService educationalInstitutionService;

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
			@RequestParam(required = false) String nameIt, @RequestParam(required = false) String location,
			@RequestParam(required = false) String locationIt, @RequestParam(required = false) StudyPlace studyPlace,
			@RequestParam(required = false) String website) {
		this.educationalInstitutionService.updateEducationalInstitution(educationalInstitutionId, nameIt, location,
				locationIt, studyPlace, website);
	}
}
