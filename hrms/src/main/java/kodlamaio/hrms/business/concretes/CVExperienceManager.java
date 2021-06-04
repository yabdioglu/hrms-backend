package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kodlamaio.hrms.business.abstracts.CVExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CVExperienceDao;
import kodlamaio.hrms.entities.concretes.CVExperience;
@Component
public class CVExperienceManager implements CVExperienceService {

	private CVExperienceDao cvExperienceDao;
	
	@Autowired
	public CVExperienceManager(CVExperienceDao cvExperienceDao) {
		super();
		this.cvExperienceDao = cvExperienceDao;
	}
	@Override
	public Result add(CVExperience cvExperience) {
		this.cvExperienceDao.save(cvExperience);
		return new SuccessResult("Web adresi başarıyla eklendi.");
	}

	@Override
	public DataResult<List<CVExperience>> getAll() {
		return new SuccessDataResult<List<CVExperience>>(this.cvExperienceDao.findAll(),"İş deneyimleri listelendi.");
	}

}
