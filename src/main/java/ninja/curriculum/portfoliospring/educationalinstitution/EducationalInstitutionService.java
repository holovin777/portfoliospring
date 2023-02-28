package ninja.curriculum.portfoliospring.educationalinstitution;

import ninja.curriculum.portfoliospring.customer.Customer;
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

    public void updateEducationalInstitution(Long educationalInstitutionId, String nameItaly) {
        Optional<EducationalInstitution> educationalInstitutionOptional = this.educationalInstitutionRepository.findById(educationalInstitutionId);
        if (educationalInstitutionOptional.isPresent()) {
            EducationalInstitution educationalInstitution = educationalInstitutionOptional.get();
            if (nameItaly != null) {
                educationalInstitution.setNameItaly(nameItaly);
                educationalInstitutionRepository.save(educationalInstitution);
            }
        } else {
            throw new IllegalStateException("Educational institution with UUID " + educationalInstitutionId + " doesn't exists");
        }
    }
}
