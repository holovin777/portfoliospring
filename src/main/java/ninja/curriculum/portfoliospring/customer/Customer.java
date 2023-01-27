package ninja.curriculum.portfoliospring.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import ninja.curriculum.portfoliospring.qualification.Qualification;
import ninja.curriculum.portfoliospring.workingexperience.WorkingExperience;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "Customer")
@Table(name = "customer",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "customer_phone_number_unique",
                        columnNames = "phone_number"
                ),
                @UniqueConstraint(
                        name = "customer_email_unique",
                        columnNames = "email"
                ),
                @UniqueConstraint(
                        name = "customer_website_unique",
                        columnNames = "website"
                )
        }
)
public class Customer {

    @Id
    @Column(
            name = "id",
            nullable = false,
            updatable = false,
            columnDefinition = "UUID"
    )
    private UUID id;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
            name = "phone_number",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String phoneNumber;

    @Column(
            name = "birthday",
            columnDefinition = "DATE"
    )
    private LocalDate birthday;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "residence",
            columnDefinition = "TEXT"
    )
    private String residence;

    @Column(
            name = "website",
            columnDefinition = "TEXT"
    )
    private String website;

    @Column(
            name = "driving_license",
            columnDefinition = "TEXT"
    )
    private String drivingLicense;

    @JsonIgnore
    @OneToMany(
            mappedBy = "customer",
            cascade = {CascadeType.ALL},
            orphanRemoval = true
    )
    private List<WorkingExperience> workingExperiences = new ArrayList<>();

    @JsonIgnore
    @OneToMany(
            mappedBy = "customer",
            cascade = {CascadeType.ALL},
            orphanRemoval = true
    )
    private List<Qualification> qualifications = new ArrayList<>();

    @JsonIgnore
    @Column(
            name = "password",
            columnDefinition = "TEXT"
    )
    private String password;


    public Customer(UUID id, String firstName, String lastName, String phoneNumber, String email, String residence, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.residence = residence;
        this.password = password;
    }

    public Customer() {
    }


    public List<WorkingExperience> getWorkingExperiences() {
        return workingExperiences;
    }

    public void addWorkingExperience(WorkingExperience workingExperience) {
        if (!this.workingExperiences.contains(workingExperience)) {
            this.workingExperiences.add(workingExperience);
            workingExperience.setCustomer(this);
        }
    }

    public void removeWorkingExperience(WorkingExperience workingExperience) {
        if (this.workingExperiences.contains(workingExperience)) {
            this.workingExperiences.remove(workingExperience);
            workingExperience.setCustomer(null);
        }
    }

    public void addQualification(Qualification qualification) {
        if (!this.qualifications.contains(qualification)) {
            this.qualifications.add(qualification);
            qualification.setCustomer(this);
        }
    }

    public void removeQualification(Qualification qualification) {
        if (this.qualifications.contains(qualification)) {
            this.qualifications.remove(qualification);
            qualification.setCustomer(null);
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public List<Qualification> getQualifications() {
        return this.qualifications;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return firstName.equals(customer.firstName) && lastName.equals(customer.lastName) && phoneNumber.equals(customer.phoneNumber) && Objects.equals(birthday, customer.birthday) && email.equals(customer.email) && Objects.equals(residence, customer.residence) && Objects.equals(website, customer.website) && Objects.equals(drivingLicense, customer.drivingLicense) && Objects.equals(workingExperiences, customer.workingExperiences) && Objects.equals(qualifications, customer.qualifications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber, birthday, email, residence, website, drivingLicense, workingExperiences, qualifications);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", residence='" + residence + '\'' +
                ", website='" + website + '\'' +
                ", drivingLicense='" + drivingLicense + '\'' +
                ", workingExperiences=" + workingExperiences +
                ", qualifications=" + qualifications +
                ", password='" + password + '\'' +
                '}';
    }
}
