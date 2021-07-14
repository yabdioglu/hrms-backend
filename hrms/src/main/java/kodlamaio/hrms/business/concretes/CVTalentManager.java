package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CVTalentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CVTalentDao;
import kodlamaio.hrms.entities.concretes.CVTalent;
import kodlamaio.hrms.entities.dtos.CVTalentSetDto;
@Service
public class CVTalentManager implements CVTalentService{
	private CVTalentDao cvTalentDao;
	private ModelMapper modelMapper;

	@Autowired
	public CVTalentManager(CVTalentDao cvTalentDao, ModelMapper modelMapper) {
		super();
		this.cvTalentDao = cvTalentDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result add(CVTalent cvTalent) {
		this.cvTalentDao.save(cvTalent);
		return new SuccessResult("Talent successfully added.");
	}

	@Override
	public DataResult<List<CVTalent>> getAll() {
		return new SuccessDataResult<List<CVTalent>>(this.cvTalentDao.findAll(), "Talents listed.");
	}

	@Override
	public Result addTalent(CVTalentSetDto cvTalentSetDto) {
		CVTalent cvTalent = modelMapper.map(cvTalentSetDto, CVTalent.class);
		this.cvTalentDao.save(cvTalent);
		return new SuccessResult("Talent added");
	}
	
	@Override
	public Result deleteTalent(int talentId) {
		this.cvTalentDao.deleteById(talentId);
		return new SuccessResult("Talent deleted");
	}
	
	@Override
	public DataResult<List<CVTalent>> getByCurriculumVitaeId(int curriculumVitaeId) {
		return new SuccessDataResult<List<CVTalent>>(this.cvTalentDao.getByCurriculumVitaeId(curriculumVitaeId),"Talents listed");
	}

}
