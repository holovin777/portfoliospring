package ninja.curriculum.portfoliospring.institution.school;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import ninja.curriculum.portfoliospring.customer.Customer;

import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "SchoolQualification")
@Table(name = "school_qualification")
public class SchoolQualification {
    @EmbeddedId
    private SchoolQualificationId id;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(
            name = "customer_id",
            foreignKey = @ForeignKey(name = "school_qualification_customer_id_fk")
    )
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @MapsId("schoolId")
    @JoinColumn(
            name = "school_id",
            foreignKey = @ForeignKey(name = "school_qualification_school_id_fk")
    )
    private School school;

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

    public SchoolQualification(SchoolQualificationId id, Customer customer, School school, LocalDate startedStudying, LocalDate finishedStudying) {
        this.id = id;
        this.customer = customer;
        this.school = school;
        this.startedStudying = startedStudying;
        this.finishedStudying = finishedStudying;
    }

    public SchoolQualification(SchoolQualificationId id, Customer customer, School school, LocalDate startedStudying) {
        this.id = id;
        this.customer = customer;
        this.school = school;
        this.startedStudying = startedStudying;
    }

    public SchoolQualification() {
    }

    public SchoolQualificationId getId() {
        return id;
    }

    public void setId(SchoolQualificationId id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
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
        SchoolQualification that = (SchoolQualification) o;
        return id.equals(that.id) && customer.equals(that.customer) && school.equals(that.school) && startedStudying.equals(that.startedStudying) && Objects.equals(finishedStudying, that.finishedStudying);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, school, startedStudying, finishedStudying);
    }

    @Override
    public String toString() {
        return "SchoolQualification{" +
                "id=" + id +
                ", customer=" + customer +
                ", school=" + school +
                ", startedStudying=" + startedStudying +
                ", finishedStudying=" + finishedStudying +
                '}';
    }
}
