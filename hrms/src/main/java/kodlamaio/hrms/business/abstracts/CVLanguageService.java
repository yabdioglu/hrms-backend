package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CVLanguage;
import kodlamaio.hrms.entities.dtos.CVLanguageSetDto;

public interface CVLanguageService {
	Result addLanguage(CVLanguageSetDto cvLanguageSetDto);
	Result add(CVLanguage cvLanguage);
	DataResult<List<CVLanguage>> getAll();
	DataResult<List<CVLanguage>> getByCurriculumVitaeId(int curriculumVitaeId);
	Result deleteLanguage(int languageId);

}
