package ninja.curriculum.portfoliospring.painting.medium;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "medium")
public class Medium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;


    public Medium() {}

    public Medium(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
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
        Medium medium = (Medium) o;
        return Objects.equals(id, medium.id) && Objects.equals(name, medium.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Medium{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
