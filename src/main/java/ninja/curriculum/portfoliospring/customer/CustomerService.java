package ninja.curriculum.portfoliospring.customer;

import ninja.curriculum.portfoliospring.qualification.Qualification;
import ninja.curriculum.portfoliospring.qualification.QualificationRepository;
import ninja.curriculum.portfoliospring.social.Social;
import ninja.curriculum.portfoliospring.social.SocialRepository;
import ninja.curriculum.portfoliospring.workingexperience.WorkingExperience;
import ninja.curriculum.portfoliospring.workingexperience.WorkingExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

@Service
@Transactional(readOnly = true)
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final QualificationRepository qualificationRepository;
    private final SocialRepository socialRepository;
    private final WorkingExperienceRepository workingExperienceRepository;

    public CustomerService(
            CustomerRepository customerRepository,
            QualificationRepository qualificationRepository,
            SocialRepository socialRepository,
            WorkingExperienceRepository workingExperienceRepository
    ) {
        this.customerRepository = customerRepository;
        this.qualificationRepository = qualificationRepository;
        this.socialRepository = socialRepository;
        this.workingExperienceRepository = workingExperienceRepository;
    }

    public List<Customer> getCustomers() {
        return this.customerRepository.findAll();
    }

    @Transactional
    public void addCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findByEmail(customer.getEmail());
        if (customerOptional.isPresent()) {
            throw new IllegalStateException("Customer with email " + customer.getEmail() + " is exists");
        }
        customer.setId(UUID.randomUUID());
        this.customerRepository.save(customer);
    }

    public Customer getCustomer(UUID customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            return customerOptional.get();
        }
        throw new IllegalStateException("Customer with UUID " + customerId + " doesn't exists");
    }


    public List<WorkingExperience> getWorkingExperiences(UUID customerId) {
        Optional<Customer> customerOptional = this.customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            return this.workingExperienceRepository.getWorkingExperienceByCustomerOrderByStartedWorkDesc(customer);
        }
        throw new IllegalStateException("Customer with UUID " + customerId + " doesn't exists");
    }

    public List<Social> getSocials(UUID customerId) {
        Optional<Customer> customerOptional = this.customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            return this.socialRepository.getSocialByCustomer(customer);
        }
        throw new IllegalStateException("Customer with UUID " + customerId + " doesn't exists");
    }

    public List<Qualification> getQualifications(UUID customerId) {
        Optional<Customer> customerOptional = this.customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            return this.qualificationRepository.getQualificationByCustomerOrderByFinishedStudyingDesc(customer);
        }
        throw new IllegalStateException("Customer with UUID " + customerId + " doesn't exists");
    }

    @Transactional
    public void updateCustomer(
            UUID customerId,
            String phoneNumber,
            String website,
            String blog,
            LocalDate birthday,
            String email,
            String residence,
            String residenceIt,
            String desiredProfession,
            String description,
            String descriptionIt,
            String drivingLicense,
            Boolean protectedCategory
    ) {
        Optional<Customer> customerOptional = this.customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            if (phoneNumber != null) {
                customer.setPhoneNumber(phoneNumber);
                customerRepository.save(customer);
            }
            if (website != null) {
                customer.setWebsite(website);
                customerRepository.save(customer);
            }
            if (blog != null) {
                customer.setBlog(blog);
                customerRepository.save(customer);
            }
            if (birthday != null) {
                customer.setBirthday(birthday);
                customerRepository.save(customer);
            }
            if (email != null) {
                customer.setEmail(email);
                customerRepository.save(customer);
            }
            if (residence != null) {
                customer.setResidence(residence);
                customerRepository.save(customer);
            }
            if (residenceIt != null) {
                customer.setResidenceIt(residenceIt);
                customerRepository.save(customer);
            }
            if (desiredProfession != null) {
                customer.setDesiredProfession(desiredProfession);
                customerRepository.save(customer);
            }
            if (description != null) {
                customer.setDescription(description);
                customerRepository.save(customer);
            }
            if (descriptionIt != null) {
                customer.setDescriptionIt(descriptionIt);
                customerRepository.save(customer);
            }
            if (drivingLicense != null) {
                customer.setDrivingLicense(drivingLicense);
                customerRepository.save(customer);
            }
            if (protectedCategory != null) {
                customer.setProtectedCategory(protectedCategory);
                customerRepository.save(customer);
            }
        } else {
            throw new IllegalStateException("Customer with UUID " + customerId + " doesn't exists");
        }
    }
}