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
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User {
	
	@NotBlank(message = "Company name cannot be empty")
	@Column(name = "company_name")
	private String companyName;
	
	@NotBlank(message = "Web address cannot be empty")
	@Column(name = "web_address")
	private String webAddress;
	
	@NotBlank(message = "Phone number cannot be empty")
	@Column(name = "phone_number")
	private String phoneNumber;

}
