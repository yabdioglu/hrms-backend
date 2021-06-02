package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.validationRules.EmployerValidatorService;
import kodlamaio.hrms.business.validationRules.ValidationRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmployerValidatorService employerValidatorService;
	private UserService userService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerValidatorService employerValidatorService, UserService userService) {
		this.employerDao = employerDao;
		this.employerValidatorService = employerValidatorService;
		this.userService = userService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data listelendi.");
	}
	
	@Override
	public Result add(Employer employer) {
		Result result = ValidationRules.run(userService.existsByEmail(employer.getEmail()), employerValidatorService.isEmailDomainCheck(employer));
		if(!result.isSuccess()) {
			return result;
		}
		this.employerDao.save(employer);
		return new SuccessResult("İş veren kayıt edildi.");
	}



}
