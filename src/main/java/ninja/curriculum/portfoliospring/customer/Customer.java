package ninja.curriculum.portfoliospring.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import ninja.curriculum.portfoliospring.qualification.Qualification;
import ninja.curriculum.portfoliospring.workingexperience.WorkingExperience;

import java.time.LocalDate;
import java.util.*;

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

    @Column(
            name = "desired_profession",
            columnDefinition = "TEXT"
    )
    private String desiredProfession;

    @Column(
            name = "description",
            columnDefinition = "TEXT"
    )
    String description;

    @JsonIgnore
    @Column(
            name = "password",
            columnDefinition = "TEXT"
    )
    private String password;


    public Customer(UUID id, String firstName, String lastName, String phoneNumber, String email, String residence, String desiredProfession, String description, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.residence = residence;
        this.desiredProfession = desiredProfession;
        this.description = description;
        this.password = password;
    }

    public Customer() {
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

    public String getDesiredProfession() {
        return desiredProfession;
    }

    public void setDesiredProfession(String desiredProfession) {
        this.desiredProfession = desiredProfession;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(phoneNumber, customer.phoneNumber) && Objects.equals(birthday, customer.birthday) && Objects.equals(email, customer.email) && Objects.equals(residence, customer.residence) && Objects.equals(website, customer.website) && Objects.equals(drivingLicense, customer.drivingLicense) && Objects.equals(workingExperiences, customer.workingExperiences) && Objects.equals(qualifications, customer.qualifications) && Objects.equals(desiredProfession, customer.desiredProfession) && Objects.equals(description, customer.description) && Objects.equals(password, customer.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phoneNumber, birthday, email, residence, website, drivingLicense, workingExperiences, qualifications, desiredProfession, description, password);
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
                ", desiredProfession='" + desiredProfession + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
