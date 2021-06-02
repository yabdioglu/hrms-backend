package kodlamaio.hrms.business.validationRules;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Component
public class CandidateValidator implements CandidateValidatorService{

	@Override
	public Result nationalityIdValid(String identityNumber) {
		if(identityNumber.length() == 11) {
			return new SuccessResult();
		}
		return new ErrorResult("Kimlik numarası 11 haneli olmalı!");
	}

}
