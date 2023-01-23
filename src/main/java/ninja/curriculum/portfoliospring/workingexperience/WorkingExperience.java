package ninja.curriculum.portfoliospring.workingexperience;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import ninja.curriculum.portfoliospring.company.Company;
import ninja.curriculum.portfoliospring.company.positionatwork.PositionAtWork;
import ninja.curriculum.portfoliospring.customer.Customer;

import java.time.LocalDate;
import java.util.Objects;


@Entity(name = "WorkingExperience")
@Table(name = "working_experience")
public class WorkingExperience {

    @EmbeddedId
    private WorkingExperienceId id;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(
            name = "customer_id",
            foreignKey = @ForeignKey(name = "working_experience_customer_id_fk")
    )
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @MapsId("positionAtWorkId")
    @JoinColumn(
            name = "position_at_work_id",
            foreignKey = @ForeignKey(name = "working_experience_position_at_work_id_fk")
    )
    private PositionAtWork positionAtWork;

    @ManyToOne
    @MapsId("companyId")
    @JoinColumn(
            name = "company_id",
            foreignKey = @ForeignKey(name = "working_experience_company_id_fk")
    )
    private Company company;

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

    public WorkingExperience(WorkingExperienceId id, Customer customer, PositionAtWork positionAtWork, Company company, LocalDate startedWork, LocalDate finishedWork) {
        this.id = id;
        this.customer = customer;
        this.positionAtWork = positionAtWork;
        this.company = company;
        this.startedWork = startedWork;
        this.finishedWork = finishedWork;
    }

    public WorkingExperience(WorkingExperienceId id, Customer customer, PositionAtWork positionAtWork, Company company, LocalDate startedWork) {
        this.id = id;
        this.customer = customer;
        this.positionAtWork = positionAtWork;
        this.company = company;
        this.startedWork = startedWork;
    }

    public WorkingExperience() {
    }

    public WorkingExperienceId getId() {
        return id;
    }

    public void setId(WorkingExperienceId id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkingExperience that = (WorkingExperience) o;
        return id.equals(that.id) && customer.equals(that.customer) && positionAtWork.equals(that.positionAtWork) && company.equals(that.company) && startedWork.equals(that.startedWork) && Objects.equals(finishedWork, that.finishedWork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, positionAtWork, company, startedWork, finishedWork);
    }

    @Override
    public String toString() {
        return "WorkingExperience{" +
                "id=" + id +
                ", customer=" + customer +
                ", positionAtWork=" + positionAtWork +
                ", company=" + company +
                ", startedWork=" + startedWork +
                ", finishedWork=" + finishedWork +
                '}';
    }
}
