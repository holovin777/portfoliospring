package ninja.curriculum.portfoliospring.course;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourses() {
        return this.courseRepository.findAll();
    }

    public void addCourse(Course course) {
        Optional<Course> courseOptional = courseRepository.findByName(course.getName());
        if (courseOptional.isEmpty()) {
            this.courseRepository.save(course);
        }
    }

    public void removeCourse(Long courseId) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        if (courseOptional.isPresent()) {
            this.courseRepository.deleteById(courseId);
        }
    }

    public void updateCourse(Long courseId, String name) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            if (name != null) {
                course.setName(name);
                this.courseRepository.save(course);
            } else {
                throw new IllegalStateException("Course with id " + courseId + " doesn't exists");
            }
        }
    }
}
