package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kodlamaio.hrms.business.abstracts.CVSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CVSchoolDao;
import kodlamaio.hrms.entities.concretes.CVSchool;
import kodlamaio.hrms.entities.dtos.CVSchoolAddDto;
@Component
public class CVSchoolManager implements CVSchoolService {
	private CVSchoolDao cvSchoolDao;
	private ModelMapper modelMapper;
	
	@Autowired
	public CVSchoolManager(CVSchoolDao cvSchoolDao, ModelMapper modelMapper) {
		super();
		this.cvSchoolDao = cvSchoolDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result add(CVSchool cvSchool) {
		this.cvSchoolDao.save(cvSchool);
		return new SuccessResult("School successfully added.");
	}

	@Override
	public DataResult<List<CVSchool>> getAll() {
		return new SuccessDataResult<List<CVSchool>>(this.cvSchoolDao.findAll(), "Schools listed.");
	}

	@Override
	public Result addSchool(CVSchoolAddDto cvSchoolAddDto) {
		CVSchool cvSchool = modelMapper.map(cvSchoolAddDto, CVSchool.class);
		this.cvSchoolDao.save(cvSchool);
		return new SuccessResult("School added");
	}

	@Override
	public Result deleteSchool(int schoolId) {
		this.cvSchoolDao.deleteById(schoolId);
		return new SuccessResult("School deleted");
	}

	@Override
	public DataResult<List<CVSchool>> getByCurriculumVitaeId(int curriculumVitaeId) {
		return new SuccessDataResult<List<CVSchool>>(this.cvSchoolDao.getByCurriculumVitaeId(curriculumVitaeId),"School listed");
	}

}
