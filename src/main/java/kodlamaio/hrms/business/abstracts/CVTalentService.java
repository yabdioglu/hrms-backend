package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CVTalent;
import kodlamaio.hrms.entities.dtos.CVTalentSetDto;

public interface CVTalentService {
	Result addTalent(CVTalentSetDto cvTalentSetDto);
	Result add(CVTalent cvTalent);
	DataResult<List<CVTalent>> getAll();
	Result deleteTalent(int talentId);
	DataResult<List<CVTalent>> getByCurriculumVitaeId(int curriculumVitaeId);

}
