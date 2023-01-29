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
        this.educationalInstitutionRepository.save(educationalInstitution);
    }

    public void removeEducationalInstitution(Long educationalInstitutionId) {
        Optional<EducationalInstitution> educationalInstitutionOptional = educationalInstitutionRepository.findById(educationalInstitutionId);
        if (educationalInstitutionOptional.isPresent()) {
            this.educationalInstitutionRepository.deleteById(educationalInstitutionId);
        }
    }
}
