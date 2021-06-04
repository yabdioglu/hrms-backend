package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kodlamaio.hrms.business.abstracts.CVTalentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CVTalentDao;
import kodlamaio.hrms.entities.concretes.CVTalent;
@Component
public class CVTalentManager implements CVTalentService{
	private CVTalentDao cvTalentDao;
	
	@Autowired
	public CVTalentManager(CVTalentDao cvTalentDao) {
		super();
		this.cvTalentDao = cvTalentDao;
	}

	@Override
	public Result add(CVTalent cvTalent) {
		this.cvTalentDao.save(cvTalent);
		return new SuccessResult("Okul başarıyla eklendi.");
	}

	@Override
	public DataResult<List<CVTalent>> getAll() {
		return new SuccessDataResult<List<CVTalent>>(this.cvTalentDao.findAll(), "Diller listelendi.");
	}

}
