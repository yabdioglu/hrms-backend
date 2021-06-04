package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","curriculumVitaes"})
public class Candidate extends User{
	@NotNull
	@NotBlank
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull
	@NotBlank
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull
	@NotBlank
	@Column(name = "identity_number")
	private String identityNumber;
	
	
	@Column(name = "birth_year")
	private int birthYear;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CurriculumVitae> curriculumVitaes;
	
	

}
