package ninja.curriculum.portfoliospring.company.positionatwork;
import jakarta.persistence.*;
import java.util.Objects;

import static jakarta.persistence.GenerationType.SEQUENCE;


@Entity(name = "PositionAtWork")
@Table(
        name = "position_at_work",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "position_at_work_name_unique",
                        columnNames = "name"
                )
        }
)
public class PositionAtWork {
    @Id
    @SequenceGenerator(
            name = "position_at_work_sequence",
            sequenceName = "position_at_work_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "position_at_work_sequence"
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

    public PositionAtWork(String name) {
        this.name = name;
    }

    public PositionAtWork() {
    }

    public Long getId() {
        return id;
    }

    public String getNameIt() {
        return nameIt;
    }

    public void setNameIt(String nameIt) {
        this.nameIt = nameIt;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionAtWork that = (PositionAtWork) o;
        return name.equals(that.name) && Objects.equals(nameIt, that.nameIt);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, nameIt);
    }
    @Override
    public String toString() {
        return "PositionAtWork{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameIt='" + nameIt + '\'' +
                '}';
    }
}
