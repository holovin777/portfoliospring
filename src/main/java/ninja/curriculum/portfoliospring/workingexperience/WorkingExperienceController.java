package ninja.curriculum.portfoliospring.workingexperience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/working-experience")
public class WorkingExperienceController {
    private final WorkingExperienceService workingExperienceService;

    @Autowired
    public WorkingExperienceController(WorkingExperienceService workingExperienceService) {
        this.workingExperienceService = workingExperienceService;
    }

    @GetMapping(path = "/all")
    public List<WorkingExperience> getWorkingExperiences() {
        return this.workingExperienceService.getWorkingExperiences();
    }

    @PostMapping
    public void addWorkingExperience(@RequestBody WorkingExperience workingExperience) {
        this.workingExperienceService.addWorkingExperience(workingExperience);
    }

    @PutMapping(path = "/{workingExperienceId}/update")
    public void updateWorkingExperience(@PathVariable Long workingExperienceId,
                                        @RequestParam(required = false) LocalDate startedDate,
                                        @RequestParam(required = false) LocalDate finishedDate,
                                        @RequestParam(required = false) String jobDescription,
                                        @RequestParam(required = false) String jobDescriptionItaly
    ) {
        this.workingExperienceService.updateWorkingExperience(workingExperienceId, startedDate, finishedDate, jobDescription, jobDescriptionItaly);
    }
}