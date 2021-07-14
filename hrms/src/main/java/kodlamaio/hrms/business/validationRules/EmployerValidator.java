package kodlamaio.hrms.business.validationRules;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employer;

@Component
public class EmployerValidator implements EmployerValidatorService{

	@Override
	public Result isEmailDomainCheck(Employer employer) {
		String email = employer.getEmail();
        String webAdress = employer.getWebAddress();

        String domain = webAdress.split("www.")[1];
        if(domain.equals(email.split("@")[1])){
            return new SuccessResult();
        }
        return new ErrorResult("E-mail does not match the domain of the web site!");
	}

}
