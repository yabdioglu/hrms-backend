package kodlamaio.hrms.core.adapters;

import kodlamaio.hrms.core.utilities.results.Result;
public interface UserCheckService {
	Result checkIfRealPerson(Long identityNumber, String firstName, String lastName, int birtDate);

}
