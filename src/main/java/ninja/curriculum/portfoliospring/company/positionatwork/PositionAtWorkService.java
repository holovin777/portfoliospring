package ninja.curriculum.portfoliospring.company.positionatwork;

import ninja.curriculum.portfoliospring.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class PositionAtWorkService {
    private final PositionAtWorkRepository positionAtWorkRepository;

    @Autowired
    public PositionAtWorkService(PositionAtWorkRepository positionAtWorkRepository) {
        this.positionAtWorkRepository = positionAtWorkRepository;
    }

    public List<PositionAtWork> getCompanies() {
        return this.positionAtWorkRepository.findAll();
    }

    @Transactional
    public void addPositionAtWork(PositionAtWork positionAtWork) {
        Optional<PositionAtWork> positionAtWorkOptional = positionAtWorkRepository.findByName(positionAtWork.getName());
        if (positionAtWorkOptional.isPresent()) {
            throw new IllegalStateException("Position at work with name " + positionAtWork.getName() + " is exists");
        }
        this.positionAtWorkRepository.save(positionAtWork);
    }

    public PositionAtWork getPositionAtWork(Long positionAtWorkId) {
        Optional<PositionAtWork> positionAtWorkOptional = positionAtWorkRepository.findById(positionAtWorkId);
        if (positionAtWorkOptional.isPresent()) {
            return positionAtWorkOptional.get();
        }
        throw new IllegalStateException("PositionAtWork with id " + positionAtWorkId + " doesn't exists");
    }

    @Transactional
    public void updatePositionAtWork(Long positionAtWorkId, String nameItaly) {
            Optional<PositionAtWork> positionAtWorkOptional = this.positionAtWorkRepository.findById(positionAtWorkId);
            if (positionAtWorkOptional.isPresent()) {
                PositionAtWork positionAtWork = positionAtWorkOptional.get();
                if (positionAtWork != null) {
                    positionAtWork.setNameItaly(nameItaly);
                    positionAtWorkRepository.save(positionAtWork);
                }
            } else {
                throw new IllegalStateException("Position at work with id " + positionAtWorkId + " doesn't exists");
            }
    }
}
