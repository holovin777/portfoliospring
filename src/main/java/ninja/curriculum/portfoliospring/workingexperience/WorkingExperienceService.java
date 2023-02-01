package ninja.curriculum.portfoliospring.workingexperience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class WorkingExperienceService {
    private final WorkingExperienceRepository workingExperienceRepository;

    @Autowired
    public WorkingExperienceService(WorkingExperienceRepository workingExperienceRepository) {
        this.workingExperienceRepository = workingExperienceRepository;
    }

    @Transactional
    public void addWorkingExperience(WorkingExperience workingExperience) {
        this.workingExperienceRepository.save(workingExperience);
    }
}
