package kodlamaio.hrms.entities.concretes;

import java.util.List;

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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	
	@Column(name = "summary")
	private String summary;
	
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
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CVSchool> cvSchools;
	
	@Valid
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CVWebAddress> cvWebAddresses;
	
	
	

}
