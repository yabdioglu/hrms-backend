package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kodlamaio.hrms.business.abstracts.CVLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CVLanguageDao;
import kodlamaio.hrms.entities.concretes.CVLanguage;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.CVLanguageSetDto;
@Component
public class CVLanguageManager implements CVLanguageService {
	
	private CVLanguageDao cvLanguageDao;
	private ModelMapper modelMapper;
	
	@Autowired
	public CVLanguageManager(CVLanguageDao cvLanguageDao, ModelMapper modelMapper) {
		super();
		this.cvLanguageDao = cvLanguageDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result add(CVLanguage cvLanguage) {
		this.cvLanguageDao.save(cvLanguage);
		return new SuccessResult("Language successfully added.");
	}

	@Override
	public DataResult<List<CVLanguage>> getAll() {
		return new SuccessDataResult<List<CVLanguage>>(this.cvLanguageDao.findAll(), "Languages listed.");
	}

	@Override
	public Result addLanguage(CVLanguageSetDto cvLanguageSetDto) {
		CVLanguage cvLanguage = modelMapper.map(cvLanguageSetDto, CVLanguage.class);
		Language language = cvLanguage.getLanguage();
		language.setLanguageName(language.getLanguageName());
		this.cvLanguageDao.save(cvLanguage);
		return new SuccessResult("Language added");
	}
	
	@Override
	public Result deleteLanguage(int languageId) {
		this.cvLanguageDao.deleteById(languageId);
		return new SuccessResult("Language deleted");
	}

	@Override
	public DataResult<List<CVLanguage>> getByCurriculumVitaeId(int curriculumVitaeId) {
		return new SuccessDataResult<List<CVLanguage>>(this.cvLanguageDao.getByCurriculumVitaeId(curriculumVitaeId),"Languages listed");
	}

}
