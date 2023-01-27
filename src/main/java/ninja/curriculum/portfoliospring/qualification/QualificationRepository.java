package ninja.curriculum.portfoliospring.qualification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Long> {
}
