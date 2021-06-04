package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kodlamaio.hrms.business.abstracts.CVLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CVLanguageDao;
import kodlamaio.hrms.entities.concretes.CVLanguage;
@Component
public class CVLanguageManager implements CVLanguageService {
	
	private CVLanguageDao cvLanguageDao;
	
	@Autowired
	public CVLanguageManager(CVLanguageDao cvLanguageDao) {
		super();
		this.cvLanguageDao = cvLanguageDao;
	}

	@Override
	public Result add(CVLanguage cvLanguage) {
		this.cvLanguageDao.save(cvLanguage);
		return new SuccessResult("Dil başarıyla eklendi.");
	}

	@Override
	public DataResult<List<CVLanguage>> getAll() {
		return new SuccessDataResult<List<CVLanguage>>(this.cvLanguageDao.findAll(), "Diller listelendi.");
	}

}
