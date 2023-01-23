package ninja.curriculum.portfoliospring.institution.college;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import ninja.curriculum.portfoliospring.customer.Customer;

import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "CollegeQualification")
@Table(name = "college_qualification")
public class CollegeQualification {
    @EmbeddedId
    private CollegeQualificationId id;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(
            name = "customer_id",
            foreignKey = @ForeignKey(name = "college_qualification_customer_id_fk")
    )
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @MapsId("collegeId")
    @JoinColumn(
            name = "college_id",
            foreignKey = @ForeignKey(name = "college_qualification_college_id_fk")
    )
    private College college;

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

    public CollegeQualification(CollegeQualificationId id, Customer customer, College college, LocalDate startedStudying, LocalDate finishedStudying) {
        this.id = id;
        this.customer = customer;
        this.college = college;
        this.startedStudying = startedStudying;
        this.finishedStudying = finishedStudying;
    }

    public CollegeQualification(CollegeQualificationId id, Customer customer, College college, LocalDate startedStudying) {
        this.id = id;
        this.customer = customer;
        this.college = college;
        this.startedStudying = startedStudying;
    }

    public CollegeQualification() {
    }

    public CollegeQualificationId getId() {
        return id;
    }

    public void setId(CollegeQualificationId id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
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
        CollegeQualification that = (CollegeQualification) o;
        return id.equals(that.id) && customer.equals(that.customer) && college.equals(that.college) && startedStudying.equals(that.startedStudying) && Objects.equals(finishedStudying, that.finishedStudying);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, college, startedStudying, finishedStudying);
    }

    @Override
    public String toString() {
        return "CollegeQualification{" +
                "id=" + id +
                ", customer=" + customer +
                ", college=" + college +
                ", startedStudying=" + startedStudying +
                ", finishedStudying=" + finishedStudying +
                '}';
    }
}
