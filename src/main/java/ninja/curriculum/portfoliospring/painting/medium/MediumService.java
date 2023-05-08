package ninja.curriculum.portfoliospring.painting.medium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MediumService {
    private final MediumRepository mediumRepository;

    @Autowired
    public MediumService(MediumRepository mediumRepository) {
        this.mediumRepository = mediumRepository;
    }

    public List<Medium> getAllMediums() {
        return mediumRepository.findAll();
    }

    public Optional<Medium> getMediumById(Long id) {
        return mediumRepository.findById(id);
    }

    @Transactional()
    public void addMedium(Medium medium) {
        mediumRepository.save(medium);
    }

    @Transactional()
    public void updateMedium(Long id, Medium updatedMedium) {
        Optional<Medium> medium = mediumRepository.findById(id);
        if (medium.isPresent()) {
            Medium mediumToUpdate = medium.get();
            mediumToUpdate.setName(updatedMedium.getName());
            mediumRepository.save(mediumToUpdate);
        }
    }

    @Transactional()
    public void deleteMedium(Long id) {
        mediumRepository.deleteById(id);
    }
}
