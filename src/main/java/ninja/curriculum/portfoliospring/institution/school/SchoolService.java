package ninja.curriculum.portfoliospring.institution.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public List<School> getSchools() {
        return this.schoolRepository.findAll();
    }

    public void addSchool(School school) {
        Optional<School> schoolOptional = schoolRepository.findByLocation(school.getLocation());
        if (schoolOptional.isPresent()) {
            throw new IllegalStateException("School with location " + school.getLocation() + " is exists");
        }
        this.schoolRepository.save(school);
    }
}
