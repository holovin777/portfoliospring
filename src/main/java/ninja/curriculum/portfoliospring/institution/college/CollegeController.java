package ninja.curriculum.portfoliospring.institution.college;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/college")
public class CollegeController {
    private final CollegeService collegeService;

    @Autowired
    public CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;
    }

    @GetMapping(path = "all")
    public List<College> getColleges() {
        return this.collegeService.getColleges();
    }

    @PostMapping
    public void addCollege(@RequestBody College college) {
        this.collegeService.addCollege(college);
    }

}
