package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CVExperience;
import kodlamaio.hrms.entities.dtos.CVExperienceAddDto;

public interface CVExperienceService {
	Result add(CVExperience cvExperience);
	Result addExperience(CVExperienceAddDto cvExperienceAddDto);
	DataResult<List<CVExperience>> getAll();
	Result deleteExperience(int experienceId);
	DataResult<List<CVExperience>> getByCurriculumVitaeId(int curriculumVitaeId);

}
