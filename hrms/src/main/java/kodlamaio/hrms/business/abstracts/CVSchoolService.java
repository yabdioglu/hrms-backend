package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CVSchool;

public interface CVSchoolService {
	Result add(CVSchool cvSchool);
	DataResult<List<CVSchool>> getAll();

}
