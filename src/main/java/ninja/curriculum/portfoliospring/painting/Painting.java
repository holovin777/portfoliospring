package ninja.curriculum.portfoliospring.painting;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import ninja.curriculum.portfoliospring.customer.Customer;
import ninja.curriculum.portfoliospring.painting.medium.Medium;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "painting")
public class Painting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "customer_painting_fk"
            )
    )
    private Customer artist;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String imageURL;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "artwork_relationship",
            joinColumns = @JoinColumn(
                    name = "painting_id",
                    foreignKey = @ForeignKey(name = "artwork_relationship_painting_id_fk")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "medium_id",
                    foreignKey = @ForeignKey(name = "artwork_relationship_medium_id_fk")
            )
    )
    private Set<Medium> mediums = new HashSet<>();

    public Painting() {}

    public Painting(String title, LocalDate date, String imageURL) {
        this.title = title;
        this.date = date;
        this.imageURL = imageURL;
    }

    public Long getId() {
        return id;
    }

    @JsonIgnore
    public Customer getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public Set<Medium> getMediums() {
        return mediums;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(Customer artist) {
        this.artist = artist;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setMediums(Set<Medium> mediums) {
        this.mediums = mediums;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void addMedium(Medium medium) {
        this.mediums.add(medium);
    }

    public void removeMedium(Medium medium) {
        this.mediums.remove(medium);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Painting painting = (Painting) o;
        return Objects.equals(id, painting.id) && Objects.equals(artist, painting.artist) && Objects.equals(title, painting.title) && Objects.equals(date, painting.date) && Objects.equals(imageURL, painting.imageURL) && Objects.equals(mediums, painting.mediums);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, artist, title, date, imageURL, mediums);
    }

    @Override
    public String toString() {
        return "Painting{" +
                "id=" + id +
                ", artist=" + artist +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", imageURL='" + imageURL + '\'' +
                ", mediums=" + mediums +
                '}';
    }
}
