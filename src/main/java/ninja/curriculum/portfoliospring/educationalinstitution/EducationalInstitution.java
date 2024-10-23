package ninja.curriculum.portfoliospring.educationalinstitution;

import jakarta.persistence.*;

import java.util.Objects;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "EducationalInstitution")
@Table(name = "educational_institution", uniqueConstraints = {
		@UniqueConstraint(name = "educational_institution_location_unique", columnNames = "location") })
public class EducationalInstitution {
	@Id
	@SequenceGenerator(name = "educational_institution_sequence", sequenceName = "educational_institution_sequence", allocationSize = 1)
	@GeneratedValue(strategy = SEQUENCE, generator = "educational_institution_sequence")
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "name", nullable = false, columnDefinition = "TEXT")
	private String name;

	@Column(name = "name_it", columnDefinition = "TEXT")
	private String nameIt;

	@Enumerated(EnumType.STRING)
	@Column(name = "study_place", nullable = false, columnDefinition = "TEXT")
	private StudyPlace studyPlace;

	@Column(name = "location", columnDefinition = "TEXT")
	private String location;

	@Column(name = "location_it", columnDefinition = "TEXT")
	private String locationIt;

	@Column(name = "website", columnDefinition = "TEXT")
	public String website;

	public EducationalInstitution(String name, String nameIt, StudyPlace studyPlace, String location, String locationIt,
			String website) {
		this.name = name;
		this.nameIt = nameIt;
		this.studyPlace = studyPlace;
		this.location = location;
		this.locationIt = locationIt;
		this.website = website;
	}

	public EducationalInstitution(String name, String nameIt, StudyPlace studyPlace, String location,
			String locationIt) {
		this.name = name;
		this.nameIt = nameIt;
		this.studyPlace = studyPlace;
		this.location = location;
		this.locationIt = locationIt;
	}

	public EducationalInstitution(String name, StudyPlace studyPlace, String location, String website) {
		this.name = name;
		this.studyPlace = studyPlace;
		this.location = location;
		this.website = website;
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

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, location, locationIt, name, nameIt, studyPlace, website);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EducationalInstitution other = (EducationalInstitution) obj;
		return Objects.equals(id, other.id) && Objects.equals(location, other.location)
				&& Objects.equals(locationIt, other.locationIt) && Objects.equals(name, other.name)
				&& Objects.equals(nameIt, other.nameIt) && studyPlace == other.studyPlace
				&& Objects.equals(website, other.website);
	}

	@Override
	public String toString() {
		return "EducationalInstitution [id=" + id + ", name=" + name + ", nameIt=" + nameIt + ", studyPlace="
				+ studyPlace + ", location=" + location + ", locationIt=" + locationIt + ", website=" + website + "]";
	}

}
