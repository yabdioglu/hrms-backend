package kodlamaio.hrms.entities.abstracts;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.core.utilities.UniqueEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotNull
	@UniqueEmail
	@Email
	@Column(name = "email", unique = true)
	private String email;
	
	@NotNull
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
	@Size(min = 8, max = 255)
	@Column(name = "password")
	private String password;
	
	@JsonIgnore
	@Column(name = "created_date")
	private LocalDateTime createdDate = LocalDateTime.now();
	
	@JsonIgnore
	@Column(name = "is_deleted")
	private boolean isDeleted;

}
