package ninja.curriculum.portfoliospring.qualification;

import ninja.curriculum.portfoliospring.customer.Customer;
import ninja.curriculum.portfoliospring.customer.CustomerRepository;
import ninja.curriculum.portfoliospring.educationalinstitution.EducationalInstitution;
import ninja.curriculum.portfoliospring.educationalinstitution.EducationalInstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@Transactional(readOnly = true)
public class QualificationService {
    private final QualificationRepository qualificationRepository;
    private final CustomerRepository customerRepository;
    private final EducationalInstitutionRepository educationalInstitutionRepository;

    @Autowired
    public QualificationService(QualificationRepository qualificationRepository, CustomerRepository customerRepository, EducationalInstitutionRepository educationalInstitutionRepository) {
        this.qualificationRepository = qualificationRepository;
        this.customerRepository = customerRepository;
        this.educationalInstitutionRepository = educationalInstitutionRepository;
    }

    public List<Qualification> getQualifications() {
        List<Qualification> qualifications = this.qualificationRepository.findAll();
        return qualifications;
    }

    public List<Qualification> getQualificationsByCustomerId(UUID customerId) {
        Optional<Customer> optionalCustomer = this.customerRepository.findById(customerId);
        Customer customer = optionalCustomer.get();
        List<Qualification> qualifications = this.qualificationRepository.getQualificationByCustomer(customer);
        return qualifications;
    }

    @Transactional
    public void addQualification(Qualification qualification) {
        this.qualificationRepository.save(qualification);
    }

    @Transactional
    public void updateQualification(Long qualificationId, UUID customerId, Long educationalInstitutionId, AcademicDegree academicDegree, String faculty, String facultyItaly, String department, String departmentItaly, String speciality, String specialityItaly, LocalDate finishedStudying, LocalDate startedStuding) {
        Optional<Qualification> qualificationOptional = this.qualificationRepository.findById(qualificationId);
        if (qualificationOptional.isPresent()) {
            Qualification qualification = qualificationOptional.get();
            if (customerId != null) {
                Optional<Customer> customerOptional = this.customerRepository.findById(customerId);
                if (customerOptional.isPresent()) {
                    qualification.setCustomer(customerOptional.get());
                    this.qualificationRepository.save(qualification);
                }
            } else if (educationalInstitutionId != null) {
                Optional<EducationalInstitution> educationalInstitutionOptional = this.educationalInstitutionRepository.findById(educationalInstitutionId);
                if (educationalInstitutionOptional.isPresent()) {
                    qualification.setEducationalInstitution(educationalInstitutionOptional.get());
                    this.qualificationRepository.save(qualification);
                }
            } else if (academicDegree != null) {
                qualification.setAcademicDegree(academicDegree);
                qualificationRepository.save(qualification);
            } else if (faculty != null) {
                qualification.setFaculty(facultyItaly);
                qualificationRepository.save(qualification);
            } else if (facultyItaly != null) {
                qualification.setFacultyIt(facultyItaly);
                qualificationRepository.save(qualification);
            } else if (department != null) {
                qualification.setDepartment(department);
                qualificationRepository.save(qualification);
            } else if (departmentItaly != null) {
                qualification.setDepartmentIt(departmentItaly);
                qualificationRepository.save(qualification);
            } else if (speciality != null) {
                qualification.setSpeciality(speciality);
                qualificationRepository.save(qualification);
            } else if (specialityItaly != null) {
                qualification.setSpecialityIt(specialityItaly);
                qualificationRepository.save(qualification);
            } else if (finishedStudying != null) {
                qualification.setFinishedStudying(finishedStudying);
                qualificationRepository.save(qualification);
            } else if (startedStuding != null) {
                qualification.setStartedStudying(startedStuding);
                qualificationRepository.save(qualification);
            }
        } else {
                throw new IllegalStateException("Argument error");
            }
        }
    }
