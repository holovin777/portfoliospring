package ninja.curriculum.portfoliospring.educationalinstitution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EducationalInstitutionRepository extends JpaRepository<EducationalInstitution, Long> {
    Optional<EducationalInstitution> findByLocation(String location);
}
