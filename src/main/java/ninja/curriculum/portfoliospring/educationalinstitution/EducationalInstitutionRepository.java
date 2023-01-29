package ninja.curriculum.portfoliospring.educationalinstitution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EducationalInstitutionRepository extends JpaRepository<EducationalInstitution, Long> {
}
