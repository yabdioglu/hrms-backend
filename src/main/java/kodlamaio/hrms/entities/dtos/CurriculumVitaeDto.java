package kodlamaio.hrms.entities.dtos;

import java.util.List;


import kodlamaio.hrms.entities.concretes.CVExperience;
import kodlamaio.hrms.entities.concretes.CVLanguage;
import kodlamaio.hrms.entities.concretes.CVSchool;
import kodlamaio.hrms.entities.concretes.CVTalent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumVitaeDto {
	private String photoLink;
	
	private String githubLink;
	
	private String linkedInLink;
	
	private String summary;
	
	private int  candidateId;
	
	private List<CVLanguage> cvLanguages;
	
	private List<CVTalent> cvTalents;
	
	private List<CVExperience> cvExperiences;

	private List<CVSchool> cvSchools;

}
