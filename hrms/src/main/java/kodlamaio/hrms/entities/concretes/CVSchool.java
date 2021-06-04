package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_schools")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","curriculumVitae"})
public class CVSchool {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank
	@NotNull
	@Column(name = "school_name")
	private String schoolName;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "start_year")
	private int startYear;
	
	@Column(name = "end_year")
	private int endYear;
	
	@Column(name = "is_graduated")
	private boolean isGraduated;
	
//	@ManyToOne
////	//@JsonIgnore
//	@JoinColumn(name = "cv_id")
//	private CurriculumVitae curriculumVitae;

}
