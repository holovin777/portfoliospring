package ninja.curriculum.portfoliospring.educationalinstitution;

import jakarta.persistence.*;

import java.util.Objects;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "EducationalInstitution")
@Table(
        name = "educational_institution",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "educational_institution_location_unique",
                        columnNames = "location"
                )
        }
)
public class EducationalInstitution {
    @Id
    @SequenceGenerator(
            name = "educational_institution_sequence",
            sequenceName = "educational_institution_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "educational_institution_sequence"
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
    @Enumerated(EnumType.STRING)
    @Column(
            name = "study_place",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private StudyPlace studyPlace;

    @Column(
            name = "location",
            columnDefinition = "TEXT"
    )
    private String location;

    public EducationalInstitution(String name, StudyPlace studyPlace, String location) {
        this.name = name;
        this.studyPlace = studyPlace;
        this.location = location;
    }

    public EducationalInstitution(String name, StudyPlace studyPlace) {
        this.name = name;
        this.studyPlace = studyPlace;
    }

    public EducationalInstitution() {
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

    public StudyPlace getStudyPlace() {
        return studyPlace;
    }

    public void setStudyPlace(StudyPlace studyPlace) {
        this.studyPlace = studyPlace;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EducationalInstitution that = (EducationalInstitution) o;
        return name.equals(that.name) && studyPlace == that.studyPlace && location.equals(that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, studyPlace, location);
    }

    @Override
    public String toString() {
        return "EducationalInstitution{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studyPlace=" + studyPlace +
                ", location='" + location + '\'' +
                '}';
    }
}
