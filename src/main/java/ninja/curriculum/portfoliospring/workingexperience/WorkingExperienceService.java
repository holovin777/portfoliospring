package ninja.curriculum.portfoliospring.workingexperience;

import ninja.curriculum.portfoliospring.company.positionatwork.PositionAtWork;
import ninja.curriculum.portfoliospring.company.positionatwork.PositionAtWorkRepository;
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
    private final PositionAtWorkRepository positionAtWorkRepository;

    @Autowired
    public WorkingExperienceService(WorkingExperienceRepository workingExperienceRepository, PositionAtWorkRepository positionAtWorkRepository) {
        this.workingExperienceRepository = workingExperienceRepository;
        this.positionAtWorkRepository = positionAtWorkRepository;
    }

    @Transactional
    public void addWorkingExperience(WorkingExperience workingExperience) {
        this.workingExperienceRepository.save(workingExperience);
    }

    public List<WorkingExperience> getWorkingExperiences() {
        return workingExperienceRepository.findAll();
    }

    @Transactional
    public void updateWorkingExperience(Long workingExperienceId, LocalDate startedWork, LocalDate finishedWork, String jobDescription, String jobDescriptionItaly, Long positionAtWorkId) {
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
            if (jobDescription != null) {
                workingExperience.setJobDescription(jobDescription);
                this.workingExperienceRepository.save(workingExperience);
            }
            if (jobDescriptionItaly != null) {
                workingExperience.setJobDescriptionItaly(jobDescriptionItaly);
                this.workingExperienceRepository.save(workingExperience);
            }
            if (positionAtWorkId != null) {
                PositionAtWork positionAtWork = positionAtWorkRepository.findById(positionAtWorkId)
                        .orElseThrow(() -> new IllegalStateException("PositionAtWork with id " + positionAtWorkId + " does not exist"));
                workingExperience.setPositionAtWork(positionAtWork);
            }
        } else {
            throw new IllegalStateException("Working experience with id " + workingExperienceId + " doesn't exists");
        }
    }
}