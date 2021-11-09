package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","curriculumVitaes"})
public class Candidate extends User{

	@NotNull
	@Size(min = 4,max = 255)
	@Column(name = "first_name")
	private String firstName;

	@NotNull
	@Size(min = 4,max = 255)
	@Column(name = "last_name")
	private String lastName;

	@NotNull
	@Size(min = 11,max = 11)
	@Column(name = "identity_number")
	private String identityNumber;
	
	@NotNull
	@Size(min = 4,max = 4)
	@Column(name = "birth_year")
	private String birthYear;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CurriculumVitae> curriculumVitaes;
	
	

}
