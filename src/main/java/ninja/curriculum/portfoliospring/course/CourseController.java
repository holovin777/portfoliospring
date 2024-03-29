package ninja.curriculum.portfoliospring.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/course")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping(path = "/all")
    public List<Course> getCourses() {
        return this.courseService.getCourses();
    }

    @PostMapping
    public void addCourse(@RequestBody Course course) {
        this.courseService.addCourse(course);
    }

    @DeleteMapping(path = "/delete/{courseId}")
    public void removeCourse(@PathVariable Long courseId) {
        this.courseService.removeCourse(courseId);
    }

    @PutMapping(path = "{courseId}/update")
    public void updateCourse(@PathVariable Long courseId, @RequestParam(required = false) String name) {
        this.courseService.updateCourse(courseId, name);
    }
}
