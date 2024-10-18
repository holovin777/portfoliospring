package ninja.curriculum.portfoliospring.social;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ninja.curriculum.portfoliospring.customer.Customer;

@Repository
public interface SocialRepository extends JpaRepository<Social, Long> {
	List<Social> getSocialByCustomer(Customer customer);
}
