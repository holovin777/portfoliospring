package ninja.curriculum.portfoliospring.institution.college;

import jakarta.persistence.*;
import java.util.Objects;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Collage")
@Table(name = "collage",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "collage_location_unique",
                        columnNames = "location"
                )
        }
)
public class College {
    @Id
    @SequenceGenerator(
            name = "college_sequence",
            sequenceName = "college_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "college_sequence"
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
            name = "location",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String location;

    public College(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public College() {
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
        College college = (College) o;
        return name.equals(college.name) && location.equals(college.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    @Override
    public String toString() {
        return "College{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

}
