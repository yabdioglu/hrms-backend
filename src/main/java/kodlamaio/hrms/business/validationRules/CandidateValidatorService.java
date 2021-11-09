package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.core.utilities.results.Result;

public interface CandidateValidatorService {
	Result nationalityIdValid(String identityNumber);

}
