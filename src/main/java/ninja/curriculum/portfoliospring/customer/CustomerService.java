package ninja.curriculum.portfoliospring.customer;

import ninja.curriculum.portfoliospring.qualification.Qualification;
import ninja.curriculum.portfoliospring.qualification.QualificationRepository;
import ninja.curriculum.portfoliospring.social.Social;
import ninja.curriculum.portfoliospring.social.SocialRepository;
import ninja.curriculum.portfoliospring.workingexperience.WorkingExperience;
import ninja.curriculum.portfoliospring.workingexperience.WorkingExperienceRepository;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasRole('ADMIN')")
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
        return this.customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalStateException("Customer with UUID " + customerId + " doesn't exists"));
    }

    public List<WorkingExperience> getWorkingExperiences(UUID customerId) {
        Customer customer = this.customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalStateException("Customer with UUID " + customerId + " doesn't exists"));
        return this.workingExperienceRepository.getWorkingExperienceByCustomerOrderByStartedWorkDesc(customer);
    }

    public List<Social> getSocials(UUID customerId) {
        Customer customer = this.customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalStateException("Customer with UUID " + customerId + " doesn't exists"));
        return this.socialRepository.getSocialByCustomer(customer);
    }

    public List<Qualification> getQualifications(UUID customerId) {
        Customer customer = this.customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalStateException("Customer with UUID " + customerId + " doesn't exists"));
        return this.qualificationRepository.getQualificationByCustomerOrderByFinishedStudyingDesc(customer);
    }

    @PreAuthorize("hasRole('ADMIN') or @customerSecurity.isOwner(#customerId, authentication.name)")
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
            Boolean protectedCategory,
            String photoUrl) {

        Customer customer = this.customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalStateException("Customer with UUID " + customerId + " doesn't exists"));

        if (phoneNumber != null) customer.setPhoneNumber(phoneNumber);
        if (website != null) customer.setWebsite(website);
        if (blog != null) customer.setBlog(blog);
        if (birthday != null) customer.setBirthday(birthday);
        if (email != null) customer.setEmail(email);
        if (residence != null) customer.setResidence(residence);
        if (residenceIt != null) customer.setResidenceIt(residenceIt);
        if (desiredProfession != null) customer.setDesiredProfession(desiredProfession);
        if (description != null) customer.setDescription(description);
        if (descriptionIt != null) customer.setDescriptionIt(descriptionIt);
        if (drivingLicense != null) customer.setDrivingLicense(drivingLicense);
        if (protectedCategory != null) customer.setProtectedCategory(protectedCategory);
        if (photoUrl != null) customer.setPhotoUrl(photoUrl);

        customerRepository.save(customer);
    }
}
