package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CVExperienceAddDto {
	
	private int curriculumVitaeId;

	private String companyName;
	
	
	private String position;
	

	private int startYear;
	

	private int endYear;
	

}
