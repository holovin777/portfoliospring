package ninja.curriculum.portfoliospring.workingexperience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


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

    public List<WorkingExperience> getWorkingExperiences() {
        return workingExperienceRepository.findAll();
    }

    @Transactional
    public void updateWorkingExperience(Long workingExperienceId, LocalDate startedWork, LocalDate finishedWork) {
        Optional<WorkingExperience> workingExperienceOptional = this.workingExperienceRepository.findById(workingExperienceId);
        if (workingExperienceOptional.isPresent()) {
            WorkingExperience workingExperience = workingExperienceOptional.get();
            if (startedWork != null) {
                workingExperience.setStartedWork(startedWork);
                this.workingExperienceRepository.save(workingExperience);
            }
            if (finishedWork != null) {
                workingExperience.setFinishedWork(finishedWork);
                this.workingExperienceRepository.save(workingExperience);
            }
        } else {
            throw new IllegalStateException("Working experience with id " + workingExperienceId + " doesn't exists");
        }
    }
}