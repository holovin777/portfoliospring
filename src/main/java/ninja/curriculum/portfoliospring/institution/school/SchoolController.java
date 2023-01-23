package ninja.curriculum.portfoliospring.institution.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/school")
public class SchoolController {
    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping(path = "all")
    public List<School> getSchools() {
        return this.schoolService.getSchools();
    }

    @PostMapping
    public void addSchool(@RequestBody School school) {
        this.schoolService.addSchool(school);
    }

}
