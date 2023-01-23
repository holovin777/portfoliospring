package ninja.curriculum.portfoliospring.customer;

import ninja.curriculum.portfoliospring.company.Company;
import ninja.curriculum.portfoliospring.company.CompanyRepository;
import ninja.curriculum.portfoliospring.company.positionatwork.PositionAtWork;
import ninja.curriculum.portfoliospring.company.positionatwork.PositionAtWorkRepository;
import ninja.curriculum.portfoliospring.institution.college.CollegeQualification;
import ninja.curriculum.portfoliospring.institution.college.CollegeQualificationId;
import ninja.curriculum.portfoliospring.institution.college.CollegeRepository;
import ninja.curriculum.portfoliospring.institution.school.School;
import ninja.curriculum.portfoliospring.institution.college.College;
import ninja.curriculum.portfoliospring.institution.school.SchoolQualification;
import ninja.curriculum.portfoliospring.institution.school.SchoolQualificationId;
import ninja.curriculum.portfoliospring.institution.school.SchoolRepository;
import ninja.curriculum.portfoliospring.workingexperience.WorkingExperience;
import ninja.curriculum.portfoliospring.workingexperience.WorkingExperienceId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final PositionAtWorkRepository positionAtWorkRepository;
    private final CompanyRepository companyRepository;
    private final SchoolRepository schoolRepository;
    private final CollegeRepository collegeRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository,
                           PositionAtWorkRepository positionAtWorkRepository,
                           CompanyRepository companyRepository,
                           SchoolRepository schoolRepository, CollegeRepository collegeRepository) {
        this.customerRepository = customerRepository;
        this.positionAtWorkRepository = positionAtWorkRepository;
        this.companyRepository = companyRepository;
        this.schoolRepository = schoolRepository;
        this.collegeRepository = collegeRepository;
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

    @Transactional
    public void addWorkingExperience(UUID customerId, Long positionAtWorkId, Long companyId, LocalDate startedWork, LocalDate finishedWork) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        Optional<PositionAtWork> positionAtWorkOptional = positionAtWorkRepository.findById(positionAtWorkId);
        Optional<Company> companyOptional = companyRepository.findById(companyId);
        if (customerOptional.isPresent()) {
            if (positionAtWorkOptional.isPresent()) {
                if (companyOptional.isPresent()) {
                    Customer customer = customerOptional.get();
                    Company company = companyOptional.get();
                    PositionAtWork positionAtWork = positionAtWorkOptional.get();
                    WorkingExperience workingExperience;
                    if (finishedWork == null) {
                        workingExperience = new WorkingExperience(
                                new WorkingExperienceId(customerId, companyId, positionAtWorkId),
                                customer,
                                positionAtWork,
                                company,
                                startedWork
                        );
                    } else {
                        workingExperience = new WorkingExperience(
                                new WorkingExperienceId(customerId, companyId, positionAtWorkId),
                                customer,
                                positionAtWork,
                                company,
                                startedWork,
                                finishedWork
                        );
                    }
                    customer.addWorkingExperience(workingExperience);
                    customerRepository.save(customer);
                } else {
                    throw new IllegalStateException("Company with id " + companyId + " doesn't exists");
                }
            } else {
                throw new IllegalStateException("PositionAtWork with id " + positionAtWorkId + " doesn't exists");
            }

        } else {
            throw new IllegalStateException("Customer with UUID " + customerId + " doesn't exists");
        }
    }

    @Transactional
    public void addSchoolQualification(UUID customerId, Long schoolId, LocalDate startedStudying, LocalDate finishedStudying) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        Optional<School> schoolOptional = schoolRepository.findById(schoolId);
        if (customerOptional.isPresent()) {
            if (schoolOptional.isPresent()) {
                Customer customer = customerOptional.get();
                School school = schoolOptional.get();
                SchoolQualification schoolQualification;
                if (finishedStudying == null) {
                    schoolQualification = new SchoolQualification(
                            new SchoolQualificationId(customerId, schoolId),
                            customer,
                            school,
                            startedStudying
                    );
                } else {
                    schoolQualification = new SchoolQualification(
                            new SchoolQualificationId(customerId, schoolId),
                            customer,
                            school,
                            startedStudying,
                            finishedStudying
                    );
                }
                customer.addSchoolQualification(schoolQualification);
                customerRepository.save(customer);
            } else {
                throw new IllegalStateException("School with id " + schoolId + " doesn't exists");
            }
        } else {
            throw new IllegalStateException("Customer with UUID " + customerId + " doesn't exists");
        }
    }

    public void addCollegeQualification(UUID customerId, Long collegeId, LocalDate startedStudying, LocalDate finishedStudying) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        Optional<College> collegeOptional = collegeRepository.findById(collegeId);
        if (customerOptional.isPresent()) {
            if (collegeOptional.isPresent()) {
                Customer customer = customerOptional.get();
                College college = collegeOptional.get();
                CollegeQualification collegeQualification;
                if (finishedStudying == null) {
                    collegeQualification = new CollegeQualification(
                            new CollegeQualificationId(customerId, collegeId),
                            customer,
                            college,
                            startedStudying
                    );
                } else {
                    collegeQualification = new CollegeQualification(
                            new CollegeQualificationId(customerId, collegeId),
                            customer,
                            college,
                            startedStudying,
                            finishedStudying
                    );
                }
                customer.addCollegeQualification(collegeQualification);
                customerRepository.save(customer);
            } else {
                throw new IllegalStateException("College with id " + collegeId + " doesn't exists");
            }
        } else {
            throw new IllegalStateException("Customer with UUID " + customerId + " doesn't exists");
        }
    }
}
