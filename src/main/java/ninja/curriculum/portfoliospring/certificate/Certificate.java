package ninja.curriculum.portfoliospring.certificate;

import jakarta.persistence.*;
import ninja.curriculum.portfoliospring.customer.Customer;

import java.time.LocalDate;
import java.util.Objects;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Certificate")
@Table(name = "certificate")
public class Certificate {

    @Id
    @SequenceGenerator(
            name = "certificate_sequence",
            sequenceName = "certificate_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "certificate_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;
    @Column(
            name = "brand_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String brandName;
    @Column(
            name = "completed_date",
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDate completedDate;
    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "certificate_customer_fk")

    )
    private Customer customer;

    public Certificate(String name, String brandName, LocalDate completedDate, Customer customer) {
        this.name = name;
        this.brandName = brandName;
        this.completedDate = completedDate;
        this.customer = customer;
    }

    public Certificate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public LocalDate getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(LocalDate completedDate) {
        this.completedDate = completedDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Certificate that = (Certificate) o;
        return name.equals(that.name) && brandName.equals(that.brandName) && completedDate.equals(that.completedDate) && customer.equals(that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, brandName, completedDate, customer);
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brandName='" + brandName + '\'' +
                ", completedDate=" + completedDate +
                ", customer=" + customer +
                '}';
    }
}
