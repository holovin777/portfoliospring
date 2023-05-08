package ninja.curriculum.portfoliospring.painting;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PaintingRepository extends JpaRepository<Painting, Long> {
    List<Painting> findAllByArtistId(UUID artistId);
}
