package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
public class Candidate extends User{
	@NotBlank(message = "First name cannot be empty")
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank(message = "Last name cannot be empty")
	@Column(name = "last_name")
	private String lastName;
	
	@NotBlank(message = "Identity number cannot be empty")
	@Column(name = "identity_number")
	private String identityNumber;
	
	@Column(name = "birth_year")
	private int birthYear;
	

}
