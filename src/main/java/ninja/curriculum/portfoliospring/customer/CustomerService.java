package ninja.curriculum.portfoliospring.customer;

import ninja.curriculum.portfoliospring.certificate.Certificate;
import ninja.curriculum.portfoliospring.company.CompanyRepository;
import ninja.curriculum.portfoliospring.company.positionatwork.PositionAtWorkRepository;
import ninja.curriculum.portfoliospring.educationalinstitution.EducationalInstitutionRepository;
import ninja.curriculum.portfoliospring.qualification.Qualification;
import ninja.curriculum.portfoliospring.qualification.QualificationRepository;
import ninja.curriculum.portfoliospring.workingexperience.WorkingExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final PositionAtWorkRepository positionAtWorkRepository;
    private final CompanyRepository companyRepository;
    private final EducationalInstitutionRepository educationalInstitutionRepository;
    private final QualificationRepository qualificationRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository,
                           PositionAtWorkRepository positionAtWorkRepository,
                           CompanyRepository companyRepository,
                           EducationalInstitutionRepository educationalInstitutionRepository,
                           QualificationRepository qualificationRepository) {
        this.customerRepository = customerRepository;
        this.positionAtWorkRepository = positionAtWorkRepository;
        this.companyRepository = companyRepository;
        this.educationalInstitutionRepository = educationalInstitutionRepository;
        this.qualificationRepository = qualificationRepository;
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
            return customer.getWorkingExperiences();
        }
        throw new IllegalStateException("Customer with UUID " + customerId + " doesn't exists");
    }

    public List<Qualification> getQualifications(UUID customerId) {
        Optional<Customer> customerOptional = this.customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            return customer.getQualifications();
        }
        throw new IllegalStateException("Customer with UUID " + customerId + " doesn't exists");
    }

    public List<Certificate> getCertificates(UUID customerId) {
        Optional<Customer> customerOptional = this.customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            return customer.getCertificates();
        }
        throw new IllegalStateException("Customer with UUID " + customerId + " doesn't exists");
    }
}
