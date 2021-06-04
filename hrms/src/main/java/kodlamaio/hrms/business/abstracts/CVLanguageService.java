package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CVLanguage;

public interface CVLanguageService {
	Result add(CVLanguage cvLanguage);
	DataResult<List<CVLanguage>> getAll();

}
