package ninja.curriculum.portfoliospring.workingexperience;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class WorkingExperienceId implements Serializable {

    @Column(name = "customer_id")
    private UUID customerId;

    @Column(name = "position_at_work_id")
    private Long positionAtWorkId;

    @Column(name = "company_id")
    private Long companyId;


    public WorkingExperienceId(UUID customerId, Long positionAtWorkId, Long companyId) {
        this.customerId = customerId;
        this.positionAtWorkId = positionAtWorkId;
        this.companyId = companyId;
    }


    public WorkingExperienceId() {
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public Long getPositionAtWorkId() {
        return positionAtWorkId;
    }

    public void setPositionAtWorkId(Long positionAtWorkId) {
        this.positionAtWorkId = positionAtWorkId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkingExperienceId that = (WorkingExperienceId) o;
        return Objects.equals(customerId, that.customerId) && Objects.equals(positionAtWorkId, that.positionAtWorkId) && Objects.equals(companyId, that.companyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, positionAtWorkId, companyId);
    }

    @Override
    public String toString() {
        return "WorkingExperienceId{" +
                "customerId=" + customerId +
                ", positionAtWorkId=" + positionAtWorkId +
                ", companyId=" + companyId +
                '}';
    }
}
