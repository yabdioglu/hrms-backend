package kodlamaio.hrms.entities.concretes;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_talents")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","curriculumVitae"})
public class CVTalent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@ManyToOne
	//@JsonIgnore
	@JoinColumn(name = "cv_id")
	private CurriculumVitae curriculumVitae;
	
	@ManyToOne
	//@JsonIgnore
	@JoinColumn(name = "talent_id")
	private Talent talent;
	

}
