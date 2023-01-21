package ninja.curriculum.portfoliospring.company.positionatwork;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionAtWorkRepository extends JpaRepository<PositionAtWork, Long> {
}
