package ninja.curriculum.portfoliospring.customer;

import java.time.LocalDate;

public class CustomerUpdateRequest {

    private String phoneNumber;
    private String website;
    private String blog;
    private LocalDate birthday;
    private String email;
    private String residence;
    private String residenceIt;
    private String desiredProfession;
    private String description;
    private String descriptionIt;
    private String drivingLicense;
    private Boolean protectedCategory;
    private String photoUrl;

    public CustomerUpdateRequest() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public Boolean getProtectedCategory() {
        return protectedCategory;
    }

    public void setProtectedCategory(Boolean protectedCategory) {
        this.protectedCategory = protectedCategory;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
