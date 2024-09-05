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

    @Column(
            name = "name_it",
            columnDefinition = "TEXT"
    )
    private String nameIt;

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

    @Column(
            name = "location_it",
            columnDefinition = "TEXT"
    )
    private String locationIt;

    public EducationalInstitution(String name, StudyPlace studyPlace, String location, String locationIt) {
        this.name = name;
        this.studyPlace = studyPlace;
        this.location = location;
        this.locationIt = locationIt;
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

    public String getLocationIt() {
        return locationIt;
    }

    public void setLocationIt(String locationIt) {
        this.locationIt = locationIt;
    }

    public String getNameIt() {
        return nameIt;
    }

    public void setNameIt(String nameIt) {
        this.nameIt = nameIt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EducationalInstitution that = (EducationalInstitution) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(nameIt, that.nameIt) && studyPlace == that.studyPlace && Objects.equals(location, that.location) && Objects.equals(locationIt, that.locationIt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nameIt, studyPlace, location, locationIt);
    }

    @Override
    public String toString() {
        return "EducationalInstitution{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameIt='" + nameIt + '\'' +
                ", studyPlace=" + studyPlace +
                ", location='" + location + '\'' +
                ", locationIt='" + locationIt + '\'' +
                '}';
    }
}
