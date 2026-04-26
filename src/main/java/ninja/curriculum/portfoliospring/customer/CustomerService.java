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

    public List<Customer> getPublicCustomers() {
        return this.customerRepository.findAll();
    }

    public Customer getPublicCustomerBySlug(String slug) {
        return this.customerRepository.findBySlug(slug)
                .orElseThrow(() -> new IllegalStateException("Customer with slug " + slug + " doesn't exist"));
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
    public void updateCustomer(UUID customerId, CustomerUpdateRequest request) {
        Customer customer = this.customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalStateException("Customer with UUID " + customerId + " doesn't exists"));

        if (request.getSlug() != null) customer.setSlug(request.getSlug());
        if (request.getPhoneNumber() != null) customer.setPhoneNumber(request.getPhoneNumber());
        if (request.getWebsite() != null) customer.setWebsite(request.getWebsite());
        if (request.getBlog() != null) customer.setBlog(request.getBlog());
        if (request.getBirthday() != null) customer.setBirthday(request.getBirthday());
        if (request.getEmail() != null) customer.setEmail(request.getEmail());
        if (request.getResidence() != null) customer.setResidence(request.getResidence());
        if (request.getResidenceIt() != null) customer.setResidenceIt(request.getResidenceIt());
        if (request.getDesiredProfession() != null) customer.setDesiredProfession(request.getDesiredProfession());
        if (request.getDescription() != null) customer.setDescription(request.getDescription());
        if (request.getDescriptionIt() != null) customer.setDescriptionIt(request.getDescriptionIt());
        if (request.getDrivingLicense() != null) customer.setDrivingLicense(request.getDrivingLicense());
        if (request.getProtectedCategory() != null) customer.setProtectedCategory(request.getProtectedCategory());
        if (request.getPhotoUrl() != null) customer.setPhotoUrl(request.getPhotoUrl());

        customerRepository.save(customer);
    }
}
