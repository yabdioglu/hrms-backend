package kodlamaio.hrms.core.adapters;



import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class MernisServiceAdapter implements UserCheckService {
	
	@Override
	public Result checkIfRealPerson(Long identityNumber, String firstName, String lastName, int birtDate) {
		FakeMernisService fakeMernisService = new FakeMernisService();
		if(!fakeMernisService.check(identityNumber, firstName, lastName, birtDate)) {
			return new ErrorResult("Geçersiz kullanıcı girişi!");
		}
		return new SuccessResult();
	}
}
