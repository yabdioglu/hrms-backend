package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CVSchool;
import kodlamaio.hrms.entities.dtos.CVSchoolAddDto;

public interface CVSchoolService {
	Result add(CVSchool cvSchool);
	DataResult<List<CVSchool>> getAll();
	Result addSchool(CVSchoolAddDto cvSchoolAddDto);
	Result deleteSchool(int schoolId);
	DataResult<List<CVSchool>> getByCurriculumVitaeId(int curriculumVitaeId);

}
