package ninja.curriculum.portfoliospring.qualification;

import ninja.curriculum.portfoliospring.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Long> {
    List<Qualification> getQualificationByCustomerOrderByFinishedStudyingDesc(Customer customer);
    List<Qualification> getQualificationByCustomer(Customer customer);
}
