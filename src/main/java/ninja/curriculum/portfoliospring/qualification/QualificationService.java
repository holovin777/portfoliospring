package ninja.curriculum.portfoliospring.qualification;

import ninja.curriculum.portfoliospring.customer.Customer;
import ninja.curriculum.portfoliospring.customer.CustomerRepository;
import ninja.curriculum.portfoliospring.educationalinstitution.EducationalInstitution;
import ninja.curriculum.portfoliospring.educationalinstitution.EducationalInstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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

    @Transactional
    public void addQualification(Qualification qualification) {
        this.qualificationRepository.save(qualification);
    }

    @Transactional
    public void updateQualification(Long qualificationId, UUID customerId, Long educationalInstitutionId, AcademicDegree academicDegree, String faculty, String facultyItaly, String department, String departmentItaly, String speciality, String specialityItaly, LocalDate finishedStudying) {
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
            } else if (faculty != null) {
                qualification.setFaculty(facultyItaly);
            } else if (facultyItaly != null) {
                qualification.setFacultyItaly(facultyItaly);
            } else if (department != null) {
                qualification.setDepartment(department);
            } else if (departmentItaly != null) {
                qualification.setDepartmentItaly(departmentItaly);
            } else if (speciality != null) {
                qualification.setSpeciality(speciality);
            } else if (specialityItaly != null) {
                qualification.setSpecialityItaly(specialityItaly);
            } else if (finishedStudying != null) {
                qualification.setFinishedStudying(finishedStudying);
            }
        } else {
                throw new IllegalStateException("Argument error");
            }
        }
    }
