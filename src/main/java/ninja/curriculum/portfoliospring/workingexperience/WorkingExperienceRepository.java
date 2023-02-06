package ninja.curriculum.portfoliospring.workingexperience;

import ninja.curriculum.portfoliospring.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WorkingExperienceRepository extends JpaRepository<WorkingExperience, Long> {
    List<WorkingExperience> getWorkingExperienceByCustomerOrderByStartedWorkDesc(Customer customer);
}
