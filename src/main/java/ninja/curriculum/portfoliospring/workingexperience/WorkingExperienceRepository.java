package ninja.curriculum.portfoliospring.workingexperience;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WorkingExperienceRepository extends JpaRepository<WorkingExperience, Long> {
}
