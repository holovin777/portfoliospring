package ninja.curriculum.portfoliospring.workingexperience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/working-experience")
public class WorkingExperienceController {
    private final WorkingExperienceService workingExperienceService;

    @Autowired
    public WorkingExperienceController(WorkingExperienceService workingExperienceService) {
        this.workingExperienceService = workingExperienceService;
    }

    @PostMapping
    public void addWorkingExperience(@RequestBody WorkingExperience workingExperience) {
        System.out.println(workingExperience);
        this.workingExperienceService.addWorkingExperience(workingExperience);
    }
}
