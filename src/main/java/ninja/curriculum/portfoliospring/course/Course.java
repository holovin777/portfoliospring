package ninja.curriculum.portfoliospring.course;

import static jakarta.persistence.GenerationType.SEQUENCE;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name = "Course")
@Table(name = "course", uniqueConstraints = { @UniqueConstraint(name = "course_name_unique", columnNames = "name"), })
public class Course {
	@Id
	@SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1)
	@GeneratedValue(strategy = SEQUENCE, generator = "course_sequence")
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "name", nullable = false, columnDefinition = "TEXT")
	private String name;

	public Course(String name) {
		this.name = name;
	}

	public Course() {
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

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", website=" + "]";
	}

}
