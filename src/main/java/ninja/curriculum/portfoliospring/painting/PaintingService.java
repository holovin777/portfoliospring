package ninja.curriculum.portfoliospring.painting;

import ninja.curriculum.portfoliospring.customer.Customer;
import ninja.curriculum.portfoliospring.customer.CustomerRepository;
import ninja.curriculum.portfoliospring.painting.medium.Medium;
import ninja.curriculum.portfoliospring.painting.medium.MediumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class PaintingService {
    private final PaintingRepository paintingRepository;
    private final MediumRepository mediumRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public PaintingService(PaintingRepository paintingRepository, MediumRepository mediumRepository, CustomerRepository customerRepository) {
        this.paintingRepository = paintingRepository;
        this.mediumRepository = mediumRepository;
        this.customerRepository = customerRepository;
    }

    public List<Painting> getAllPaintings() {
        return paintingRepository.findAll();
    }

    public Optional<Painting> getPaintingById(Long id) {
        return paintingRepository.findById(id);
    }

    @Transactional()
    public void addPainting(Painting painting) {
        paintingRepository.save(painting);
    }

    @Transactional()
    public void updatePainting(Long id, Customer paintingArtist, String paintingTitle, LocalDate paintingDate, String paintingUrl) {
        Optional<Painting> paintingOptional = paintingRepository.findById(id);
        if (paintingOptional.isPresent()) {
            Painting painting = paintingOptional.get();
            if (paintingArtist != null) {
                painting.setArtist(paintingArtist);
                paintingRepository.save(painting);
            }
            if (paintingTitle != null) {
                painting.setTitle(paintingTitle);
                paintingRepository.save(painting);
            }
            if (paintingDate != null) {
                painting.setDate(paintingDate);
                paintingRepository.save(painting);
            }
            if (paintingUrl != null) {
                painting.setImageURL(paintingUrl);
                paintingRepository.save(painting);
            }
        } else {
            throw new IllegalStateException("Painting with id " + id + " doesn't exists");
        }
    }

    @Transactional()
    public void deletePainting(Long id) {
        paintingRepository.deleteById(id);
    }

    @Transactional()
    public void addMedium(Long paintingId, Long mediumId) {
        Optional<Painting> paintingOptional = paintingRepository.findById(paintingId);
        Optional<Medium> mediumOptional = mediumRepository.findById(mediumId);
        if (paintingOptional.isPresent() && mediumOptional.isPresent()) {
            Painting painting = paintingOptional.get();
            Medium medium = mediumOptional.get();
            painting.addMedium(medium);
            paintingRepository.save(painting);
        }
    }

    public List<Painting> getArtistPaintings(UUID artistId) {
        Optional<Customer> customerOptional = customerRepository.findById(artistId);
        if (customerOptional.isPresent()) {
            return paintingRepository.findAllByArtistId(artistId);
        }
        return null;
    }
}
