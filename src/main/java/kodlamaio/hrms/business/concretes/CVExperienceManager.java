package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CVExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CVExperienceDao;
import kodlamaio.hrms.entities.concretes.CVExperience;
import kodlamaio.hrms.entities.dtos.CVExperienceAddDto;
@Service
public class CVExperienceManager implements CVExperienceService {

	private CVExperienceDao cvExperienceDao;
	private ModelMapper modelMapper;
	
	@Autowired
	public CVExperienceManager(CVExperienceDao cvExperienceDao, ModelMapper modelMapper) {
		super();
		this.cvExperienceDao = cvExperienceDao;
		this.modelMapper = modelMapper;
	}
	@Override
	public Result add(CVExperience cvExperience) {
		this.cvExperienceDao.save(cvExperience);
		return new SuccessResult("Job Experience successfully added.");
	}

	@Override
	public DataResult<List<CVExperience>> getAll() {
		return new SuccessDataResult<List<CVExperience>>(this.cvExperienceDao.findAll(),"Job Experiences listed.");
	}
	@Override
	public Result addExperience(CVExperienceAddDto cvExperienceAddDto) {
		CVExperience cvExperience = modelMapper.map(cvExperienceAddDto, CVExperience.class);
		this.cvExperienceDao.save(cvExperience);
		return new SuccessResult("Job Experience added");
	}
	
	@Override
	public Result deleteExperience(int experienceId) {
		this.cvExperienceDao.deleteById(experienceId);
		return new SuccessResult("Job Experience deleted");
	}
	@Override
	public DataResult<List<CVExperience>> getByCurriculumVitaeId(int curriculumVitaeId) {
		return new SuccessDataResult<List<CVExperience>>(this.cvExperienceDao.getByCurriculumVitaeId(curriculumVitaeId));
	}

}
