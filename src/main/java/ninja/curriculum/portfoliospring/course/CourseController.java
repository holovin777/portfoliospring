package ninja.curriculum.portfoliospring.course;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/course")
public class CourseController {
	private final CourseService courseService;

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
