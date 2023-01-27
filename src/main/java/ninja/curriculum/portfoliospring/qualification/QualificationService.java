package ninja.curriculum.portfoliospring.qualification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class QualificationService {
    private final QualificationRepository qualificationRepository;

    @Autowired
    public QualificationService(QualificationRepository qualificationRepository) {
        this.qualificationRepository = qualificationRepository;
    }

    @Transactional
    public void addQualification(Qualification qualification) {
        this.qualificationRepository.save(qualification);
    }
}
