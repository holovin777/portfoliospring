package ninja.curriculum.portfoliospring.qualification;

import jakarta.persistence.*;
import ninja.curriculum.portfoliospring.customer.Customer;
import ninja.curriculum.portfoliospring.educationalinstitution.EducationalInstitution;

import java.time.LocalDate;
import java.util.Objects;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Qualification")
@Table(name = "qualification")
public class Qualification {
    @Id
    @SequenceGenerator(
            name = "educational_institution_sequence",
            sequenceName = "educational_institution_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "educational_institution_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "qualification_customer_fk")
    )
    private Customer customer;

    @ManyToOne
    @JoinColumn(
            name = "educational_institution_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "qualification_educational_institution_fk")
    )
    private EducationalInstitution educationalInstitution;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "academic_degree",
            columnDefinition = "TEXT"
    )
    private AcademicDegree academicDegree;

    @Column(
            name = "faculty",
            columnDefinition = "TEXT"
    )
    private String faculty;

    @Column(
            name = "department",
            columnDefinition = "TEXT"
    )
    private String department;

    @Column(
            name = "speciality",
            columnDefinition = "TEXT"
    )
    private String speciality;

    @Column(
            name = "started_studying",
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDate startedStudying;

    @Column(
            name = "finished_studying",
            columnDefinition = "DATE"
    )
    private LocalDate finishedStudying;

    public Qualification(Customer customer, EducationalInstitution educationalInstitution, AcademicDegree academicDegree, String faculty, String department, String speciality, LocalDate startedStudying, LocalDate finishedStudying) {
        this.customer = customer;
        this.educationalInstitution = educationalInstitution;
        this.academicDegree = academicDegree;
        this.faculty = faculty;
        this.department = department;
        this.speciality = speciality;
        this.startedStudying = startedStudying;
        this.finishedStudying = finishedStudying;
    }

    public Qualification(Customer customer, EducationalInstitution educationalInstitution, AcademicDegree academicDegree, String faculty, String department, String speciality, LocalDate startedStudying) {
        this.customer = customer;
        this.educationalInstitution = educationalInstitution;
        this.academicDegree = academicDegree;
        this.faculty = faculty;
        this.department = department;
        this.speciality = speciality;
        this.startedStudying = startedStudying;
    }

    public Qualification(Customer customer, EducationalInstitution educationalInstitution, String speciality, LocalDate startedStudying, LocalDate finishedStudying) {
        this.customer = customer;
        this.educationalInstitution = educationalInstitution;
        this.speciality = speciality;
        this.startedStudying = startedStudying;
        this.finishedStudying = finishedStudying;
    }

    public Qualification(Customer customer, EducationalInstitution educationalInstitution, String speciality, LocalDate startedStudying) {
        this.customer = customer;
        this.educationalInstitution = educationalInstitution;
        this.speciality = speciality;
        this.startedStudying = startedStudying;
    }

    public Qualification(Customer customer, EducationalInstitution educationalInstitution, LocalDate startedStudying) {
        this.customer = customer;
        this.educationalInstitution = educationalInstitution;
        this.startedStudying = startedStudying;
    }

    public Qualification(Customer customer, EducationalInstitution educationalInstitution, LocalDate startedStudying, LocalDate finishedStudying) {
        this.customer = customer;
        this.educationalInstitution = educationalInstitution;
        this.startedStudying = startedStudying;
        this.finishedStudying = finishedStudying;
    }

    public Qualification() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public EducationalInstitution getEducationalInstitution() {
        return educationalInstitution;
    }

    public void setEducationalInstitution(EducationalInstitution educationalInstitution) {
        this.educationalInstitution = educationalInstitution;
    }

    public AcademicDegree getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(AcademicDegree academicDegree) {
        this.academicDegree = academicDegree;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public LocalDate getStartedStudying() {
        return startedStudying;
    }

    public void setStartedStudying(LocalDate startedStudying) {
        this.startedStudying = startedStudying;
    }

    public LocalDate getFinishedStudying() {
        return finishedStudying;
    }

    public void setFinishedStudying(LocalDate finishedStudying) {
        this.finishedStudying = finishedStudying;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Qualification that = (Qualification) o;
        return customer.equals(that.customer) && educationalInstitution.equals(that.educationalInstitution) && academicDegree == that.academicDegree && Objects.equals(faculty, that.faculty) && Objects.equals(department, that.department) && Objects.equals(speciality, that.speciality) && startedStudying.equals(that.startedStudying) && Objects.equals(finishedStudying, that.finishedStudying);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, educationalInstitution, academicDegree, faculty, department, speciality, startedStudying, finishedStudying);
    }

    @Override
    public String toString() {
        return "Qualification{" +
                "id=" + id +
                ", customer=" + customer +
                ", educationalInstitution=" + educationalInstitution +
                ", academicDegree=" + academicDegree +
                ", faculty='" + faculty + '\'' +
                ", department='" + department + '\'' +
                ", speciality='" + speciality + '\'' +
                ", startedStudying=" + startedStudying +
                ", finishedStudying=" + finishedStudying +
                '}';
    }
}
