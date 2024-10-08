package ninja.curriculum.portfoliospring.workingexperience;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import ninja.curriculum.portfoliospring.company.Company;
import ninja.curriculum.portfoliospring.company.positionatwork.PositionAtWork;
import ninja.curriculum.portfoliospring.customer.Customer;

import java.time.LocalDate;
import java.util.Objects;

import static jakarta.persistence.GenerationType.SEQUENCE;


@Entity(name = "WorkingExperience")
@Table(name = "working_experience")
public class WorkingExperience {

    @Id
    @SequenceGenerator(
            name = "working_experience_sequence",
            sequenceName = "working_experience_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "working_experience_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "working_experience_customer_fk")
    )
    private Customer customer;

    @ManyToOne
    @JoinColumn(
            name = "position_at_work_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "working_experience_position_at_work_fk")
    )
    private PositionAtWork positionAtWork;

    @ManyToOne
    @JoinColumn(
            name = "company_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "working_experience_company_fk")
    )
    private Company company;

    @Column(
            name = "job_description",
            columnDefinition = "TEXT"
    )
    private String jobDescription;

    @Column(
            name = "job_description_it",
            columnDefinition = "TEXT"
    )
    private String jobDescriptionIt;

    @Column(
            name = "started_work",
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDate startedWork;

    @Column(
            name = "finished_work",
            columnDefinition = "DATE"
    )
    private LocalDate finishedWork;

    public WorkingExperience(Long id, Customer customer, PositionAtWork positionAtWork, Company company, String jobDescription, String jobDescriptionIt, LocalDate startedWork, LocalDate finishedWork) {
        this.id = id;
        this.customer = customer;
        this.positionAtWork = positionAtWork;
        this.company = company;
        this.jobDescription = jobDescription;
        this.jobDescriptionIt = jobDescriptionIt;
        this.startedWork = startedWork;
        this.finishedWork = finishedWork;
    }

    public WorkingExperience(Long id, Customer customer, PositionAtWork positionAtWork, Company company, String jobDescriptionIt, LocalDate startedWork, LocalDate finishedWork) {
        this.id = id;
        this.customer = customer;
        this.positionAtWork = positionAtWork;
        this.company = company;
        this.jobDescriptionIt = jobDescriptionIt;
        this.startedWork = startedWork;
        this.finishedWork = finishedWork;
    }

    public WorkingExperience(Customer customer, PositionAtWork positionAtWork, Company company, String jobDescription, LocalDate startedWork, LocalDate finishedWork) {
        this.customer = customer;
        this.positionAtWork = positionAtWork;
        this.company = company;
        this.jobDescription = jobDescription;
        this.startedWork = startedWork;
        this.finishedWork = finishedWork;
    }

    public WorkingExperience(Customer customer, PositionAtWork positionAtWork, Company company, String jobDescription, LocalDate startedWork) {
        this.customer = customer;
        this.positionAtWork = positionAtWork;
        this.company = company;
        this.jobDescription = jobDescription;
        this.startedWork = startedWork;
    }

    public WorkingExperience(Customer customer, PositionAtWork positionAtWork, Company company, LocalDate startedWork, LocalDate finishedWork) {
        this.customer = customer;
        this.positionAtWork = positionAtWork;
        this.company = company;
        this.startedWork = startedWork;
        this.finishedWork = finishedWork;
    }

    public WorkingExperience(Customer customer, PositionAtWork positionAtWork, Company company, LocalDate startedWork) {
        this.customer = customer;
        this.positionAtWork = positionAtWork;
        this.company = company;
        this.startedWork = startedWork;
    }

    public WorkingExperience() {
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

    public PositionAtWork getPositionAtWork() {
        return positionAtWork;
    }

    public void setPositionAtWork(PositionAtWork positionAtWork) {
        this.positionAtWork = positionAtWork;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LocalDate getStartedWork() {
        return startedWork;
    }

    public void setStartedWork(LocalDate startedWork) {
        this.startedWork = startedWork;
    }

    public LocalDate getFinishedWork() {
        return finishedWork;
    }

    public void setFinishedWork(LocalDate finishedWork) {
        this.finishedWork = finishedWork;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobDescriptionIt() {
        return jobDescriptionIt;
    }

    public void setJobDescriptionIt(String jobDescriptionIt) {
        this.jobDescriptionIt = jobDescriptionIt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkingExperience that = (WorkingExperience) o;
        return Objects.equals(id, that.id) && Objects.equals(customer, that.customer) && Objects.equals(positionAtWork, that.positionAtWork) && Objects.equals(company, that.company) && Objects.equals(jobDescription, that.jobDescription) && Objects.equals(jobDescriptionIt, that.jobDescriptionIt) && Objects.equals(startedWork, that.startedWork) && Objects.equals(finishedWork, that.finishedWork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, positionAtWork, company, jobDescription, jobDescriptionIt, startedWork, finishedWork);
    }

    @Override
    public String toString() {
        return "WorkingExperience{" +
                "id=" + id +
                ", customer=" + customer +
                ", positionAtWork=" + positionAtWork +
                ", company=" + company +
                ", jobDescription='" + jobDescription + '\'' +
                ", jobDescriptionIt='" + jobDescriptionIt + '\'' +
                ", startedWork=" + startedWork +
                ", finishedWork=" + finishedWork +
                '}';
    }
}