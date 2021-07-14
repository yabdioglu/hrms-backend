package kodlamaio.hrms.entities.concretes;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "curriculum_vitaes")
public class CurriculumVitae {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	

	@Column(name = "photo_link")
	private String photoLink;
	
	@Column(name = "github_link")
	private String githubLink;
	
	@Column(name = "linkedin_link")
	private String linkedInLink;
	
	@Column(name = "summary")
	private String summary;
	
	@JsonIgnore
	@Column(name = "created_date")
	private LocalDateTime createdDate = LocalDateTime.now();
	
	@JsonIgnore
	@Column(name = "is_deleted")
	private boolean isDeleted;
	
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@Valid //CVLanguage da bulunan valid işlemleri için kullanıldı.
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CVLanguage> cvLanguages;
	
	@Valid
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CVTalent> cvTalents;
	
	@Valid
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CVExperience> cvExperiences;

	@Valid
	@OneToMany(cascade = CascadeType.ALL, targetEntity = CVSchool.class)
	@JoinColumn(name = "cv_id")
	private List<CVSchool> cvSchools;
	
	
	

}
