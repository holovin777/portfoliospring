package ninja.curriculum.portfoliospring.company;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.Objects;

import static jakarta.persistence.GenerationType.SEQUENCE;


@Entity(name = "Company")
@Table(name = "company")
public class Company {
    @Id
    @SequenceGenerator(
            name = "company_sequence",
            sequenceName = "company_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "company_sequence"
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

    @Column(
            name = "location",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String location;

    @Column(
            name = "location_it",
            columnDefinition = "TEXT"
    )
    private String locationIt;

    public Company(String name, String nameIt, String location, String locationIt) {
        this.name = name;
        this.nameIt = nameIt;
        this.location = location;
        this.locationIt = locationIt;
    }

    public Company() {}

    public Company(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
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

    public String getNameIt() {
        return nameIt;
    }

    public void setNameIt(String nameIt) {
        this.nameIt = nameIt;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id) && Objects.equals(name, company.name) && Objects.equals(nameIt, company.nameIt) && Objects.equals(location, company.location) && Objects.equals(locationIt, company.locationIt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nameIt, location, locationIt);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameIt='" + nameIt + '\'' +
                ", location='" + location + '\'' +
                ", locationIt='" + locationIt + '\'' +
                '}';
    }
}
