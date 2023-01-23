package ninja.curriculum.portfoliospring.institution.college;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class CollegeQualificationId implements Serializable {
    @Column(name = "customer_id")
    private UUID customerId;

    @Column(name = "college_id")
    private Long collegeId;

    public CollegeQualificationId(UUID customerId, Long collegeId) {
        this.customerId = customerId;
        this.collegeId = collegeId;
    }

    public CollegeQualificationId() {
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollegeQualificationId that = (CollegeQualificationId) o;
        return customerId.equals(that.customerId) && collegeId.equals(that.collegeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, collegeId);
    }

    @Override
    public String toString() {
        return "CollegeQualificationId{" +
                "customerId=" + customerId +
                ", collegeId=" + collegeId +
                '}';
    }
}
