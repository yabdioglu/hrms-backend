package kodlamaio.hrms.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CVSchoolAddDto {
	private int curriculumVitaeId;

	private String schoolName;
	
	private String department;
	
	private int startYear;
	
	private int endYear;
	


}
