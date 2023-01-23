package ninja.curriculum.portfoliospring.institution.school;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class SchoolQualificationId implements Serializable {
    @Column(name = "customer_id")
    private UUID customerId;

    @Column(name = "school_id")
    private Long schoolId;

    public SchoolQualificationId(UUID customerId, Long schoolId) {
        this.customerId = customerId;
        this.schoolId = schoolId;
    }

    public SchoolQualificationId() {
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolQualificationId that = (SchoolQualificationId) o;
        return customerId.equals(that.customerId) && schoolId.equals(that.schoolId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, schoolId);
    }

    @Override
    public String toString() {
        return "SchoolQualificationId{" +
                "customerId=" + customerId +
                ", schoolId=" + schoolId +
                '}';
    }
}
