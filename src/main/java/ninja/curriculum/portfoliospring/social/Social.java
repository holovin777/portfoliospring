package ninja.curriculum.portfoliospring.social;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.ForeignKey;
import ninja.curriculum.portfoliospring.customer.Customer;

@Entity(name = "Social")

@Table(name = "social", uniqueConstraints = { @UniqueConstraint(name = "social_title_unique", columnNames = "title"),
		@UniqueConstraint(name = "social_link_unique", columnNames = "link") })

public class Social {
	@Id
	@SequenceGenerator(name = "social_id_sequence", sequenceName = "social_id_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "social_id_sequence")
	private Long id;

	@Column(name = "title", nullable = false, columnDefinition = "TEXT")
	private String title;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "social_customer_fk"))

	private Customer customer;
	@Column(name = "link", nullable = false, columnDefinition = "TEXT")
	private String link;

	@Column(name = "image_link", columnDefinition = "TEXT")
	private String imageLink;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	public Social(Long id, String title, Customer customer, String link, String imageLink, String description) {
		this.id = id;
		this.title = title;
		this.customer = customer;
		this.link = link;
		this.imageLink = imageLink;
		this.description = description;
	}

	public Social() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customer, description, id, imageLink, link, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Social other = (Social) obj;
		return Objects.equals(customer, other.customer) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(imageLink, other.imageLink)
				&& Objects.equals(link, other.link) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Social [id=" + id + ", title=" + title + ", customer=" + customer + ", link=" + link + ", imageLink="
				+ imageLink + ", description=" + description + "]";
	}

}