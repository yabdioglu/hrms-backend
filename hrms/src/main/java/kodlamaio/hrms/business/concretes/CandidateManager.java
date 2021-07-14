package kodlamaio.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.validationRules.CandidateValidatorService;
import kodlamaio.hrms.business.validationRules.ValidationRules;
import kodlamaio.hrms.core.adapters.UserCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private CandidateValidatorService candidateValidatorService;
	private UserCheckService userCheckService;
	private UserService userService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, CandidateValidatorService candidateValidatorService, UserCheckService userCheckService, UserService userService) {
		this.candidateDao = candidateDao;
		this.candidateValidatorService = candidateValidatorService;
		this.userCheckService = userCheckService;
		this.userService = userService;
	}
	
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data listed.");
	}


	@Override
	public Result add(Candidate candidate) {
		Result result = ValidationRules.run(userService.existsByEmail(candidate.getEmail()), candidateValidatorService.nationalityIdValid(candidate.getIdentityNumber()), userCheckService.checkIfRealPerson(Long.parseLong(candidate.getIdentityNumber()), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthYear()),identityNumberExists(candidate.getIdentityNumber()));
		if(!result.isSuccess()) {
			return result;
		}
		this.candidateDao.save(candidate);
		return new SuccessResult("Candidate registered.");
	}
	
	public Result identityNumberExists(String identityNumber){
        if (candidateDao.existsByIdentityNumber(identityNumber)){
        	return new ErrorResult("Identification number is used.");
        }
        return new SuccessResult();
    }
	
	
	
	



}
