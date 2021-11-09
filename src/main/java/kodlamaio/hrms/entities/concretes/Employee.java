package kodlamaio.hrms.entities.concretes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class Employee extends User{
	@NotNull
	@Size(min = 4,max = 255)
	@Column(name = "first_name")
	private String firstName;

	@NotNull
	@Size(min = 4,max = 255)
	@Column(name = "last_name")
	private String lastName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	private List<JobAdvertisementConfirm> jobAdvertisementConfirms;
	

}
