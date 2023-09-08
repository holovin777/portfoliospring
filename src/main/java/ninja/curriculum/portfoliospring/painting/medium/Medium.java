package ninja.curriculum.portfoliospring.painting.medium;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import ninja.curriculum.portfoliospring.painting.Painting;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "medium")
public class Medium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;


    @JsonIgnoreProperties("mediums")
    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "mediums")
    private List<Painting> paintings = new ArrayList<>();

    public Medium() {}

    public Medium(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Painting> getPaintings() {
        return paintings;
    }

    public void setPaintings(List<Painting> paintings) {
        this.paintings = paintings;
    }

    public void addPainting(Painting painting) {
        this.paintings.add(painting);
        painting.getMediums().add(this);
    }

    public void removePainting(Painting painting) {
        this.paintings.remove(painting);
        painting.getMediums().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medium medium = (Medium) o;
        return Objects.equals(id, medium.id) && Objects.equals(name, medium.name) && Objects.equals(paintings, medium.paintings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, paintings);
    }

    @Override
    public String toString() {
        return "Medium{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", paintings=" + paintings +
                '}';
    }
}
