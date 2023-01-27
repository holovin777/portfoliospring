package ninja.curriculum.portfoliospring.educationalinstitution;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationalInstitutionService {
    private final EducationalInstitutionRepository educationalInstitutionRepository;

    public EducationalInstitutionService(EducationalInstitutionRepository educationalInstitutionRepository) {
        this.educationalInstitutionRepository = educationalInstitutionRepository;
    }

    public List<EducationalInstitution> getEducationalInstitutions() {
        return this.educationalInstitutionRepository.findAll();
    }

    public void addEducationalInstitution(EducationalInstitution educationalInstitution) {
        Optional<EducationalInstitution> educationalInstitutionOptional = educationalInstitutionRepository.findByLocation(educationalInstitution.getLocation());
        if (educationalInstitutionOptional.isPresent()) {
            throw new IllegalStateException("EducationalInstitution with location " + educationalInstitution.getLocation() + " is exists");
        }
        this.educationalInstitutionRepository.save(educationalInstitution);
    }
}
