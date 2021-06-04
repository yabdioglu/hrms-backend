package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kodlamaio.hrms.business.abstracts.CVSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CVSchoolDao;
import kodlamaio.hrms.entities.concretes.CVSchool;
@Component
public class CVSchoolManager implements CVSchoolService {
	private CVSchoolDao cvSchoolDao;
	
	@Autowired
	public CVSchoolManager(CVSchoolDao cvSchoolDao) {
		super();
		this.cvSchoolDao = cvSchoolDao;
	}

	@Override
	public Result add(CVSchool cvSchool) {
		this.cvSchoolDao.save(cvSchool);
		return new SuccessResult("Okul başarıyla eklendi.");
	}

	@Override
	public DataResult<List<CVSchool>> getAll() {
		return new SuccessDataResult<List<CVSchool>>(this.cvSchoolDao.findAll(), "Diller listelendi.");
	}

}
