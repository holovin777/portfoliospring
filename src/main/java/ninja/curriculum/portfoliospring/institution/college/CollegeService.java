package ninja.curriculum.portfoliospring.institution.college;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollegeService {
    private final CollegeRepository collegeRepository;

    public CollegeService(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    public List<College> getColleges() {
        return this.collegeRepository.findAll();
    }

    public void addCollege(College college) {
        Optional<College> collegeOptional = collegeRepository.findByLocation(college.getLocation());
        if (collegeOptional.isPresent()) {
            throw new IllegalStateException("College with location " + college.getLocation() + " is exists");
        }
        this.collegeRepository.save(college);
    }

}
