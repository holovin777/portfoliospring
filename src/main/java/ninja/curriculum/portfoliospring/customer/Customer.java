package ninja.curriculum.portfoliospring.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "residence",
            columnDefinition = "TEXT"
    )
    private String residence;

    @Column(
            name = "residence_it",
            columnDefinition = "TEXT"
    )
    private String residenceIt;

    @Column(
            name = "website",
            columnDefinition = "TEXT"
    )
    private String website;

    @Column(
            name = "blog",
            columnDefinition = "TEXT"
    )
    private String blog;

    @Column(
            name = "driving_license",
            columnDefinition = "TEXT"
    )
    private String drivingLicense;

    @Column(
            name = "protected_category",
            columnDefinition = "BOOLEAN"
    )
    private Boolean protectedCategory;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "customer",
            cascade = {CascadeType.ALL},
            orphanRemoval = true
    )
    private List<WorkingExperience> workingExperiences = new ArrayList<>();

    @JsonManagedReference
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
    private String description;

    @Column(
            name = "description_it",
            columnDefinition = "TEXT"
    )
    private String descriptionIt;

    @JsonIgnore
    @Column(
            name = "password",
            columnDefinition = "TEXT"
    )
    private String password;

    public Customer(UUID id, String firstName, String lastName, String phoneNumber, LocalDate birthday, String email, String residence, String residenceIt, String website, String blog, String drivingLicense, Boolean protectedCategory, List<WorkingExperience> workingExperiences, List<Qualification> qualifications, String desiredProfession, String description, String descriptionIt, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.email = email;
        this.residence = residence;
        this.residenceIt = residenceIt;
        this.website = website;
        this.blog = blog;
        this.drivingLicense = drivingLicense;
        this.protectedCategory = protectedCategory;
        this.workingExperiences = workingExperiences;
        this.qualifications = qualifications;
        this.desiredProfession = desiredProfession;
        this.description = description;
        this.descriptionIt = descriptionIt;
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

    public String getResidenceIt() {
        return residenceIt;
    }

    public void setResidenceIt(String residenceIt) {
        this.residenceIt = residenceIt;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }


    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public void setWorkingExperiences(List<WorkingExperience> workingExperiences) {
        this.workingExperiences = workingExperiences;
    }

    public List<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<Qualification> qualifications) {
        this.qualifications = qualifications;
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

    public String getDescriptionIt() {
        return descriptionIt;
    }

    public void setDescriptionIt(String descriptionIt) {
        this.descriptionIt = descriptionIt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getProtectedCategory() {
        return protectedCategory;
    }

    public void setProtectedCategory(Boolean protectedCategory) {
        this.protectedCategory = protectedCategory;
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
        return Objects.equals(id, customer.id) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(phoneNumber, customer.phoneNumber) && Objects.equals(birthday, customer.birthday) && Objects.equals(email, customer.email) && Objects.equals(residence, customer.residence) && Objects.equals(residenceIt, customer.residenceIt) && Objects.equals(website, customer.website) && Objects.equals(blog, customer.blog) && Objects.equals(drivingLicense, customer.drivingLicense) && Objects.equals(protectedCategory, customer.protectedCategory) && Objects.equals(workingExperiences, customer.workingExperiences) && Objects.equals(qualifications, customer.qualifications) && Objects.equals(desiredProfession, customer.desiredProfession) && Objects.equals(description, customer.description) && Objects.equals(descriptionIt, customer.descriptionIt) && Objects.equals(password, customer.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phoneNumber, birthday, email, residence, residenceIt, website, blog, drivingLicense, protectedCategory, workingExperiences, qualifications, desiredProfession, description, descriptionIt, password);
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
                ", residenceIt='" + residenceIt + '\'' +
                ", website='" + website + '\'' +
                ", blog='" + blog + '\'' +
                ", drivingLicense='" + drivingLicense + '\'' +
                ", protectedCategory=" + protectedCategory +
                ", workingExperiences=" + workingExperiences +
                ", qualifications=" + qualifications +
                ", desiredProfession='" + desiredProfession + '\'' +
                ", description='" + description + '\'' +
                ", descriptionIt='" + descriptionIt + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}