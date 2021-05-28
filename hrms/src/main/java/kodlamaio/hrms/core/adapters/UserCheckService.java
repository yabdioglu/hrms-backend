package kodlamaio.hrms.core.adapters;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface UserCheckService {
	boolean checkIfRealPerson(Candidate candidate);

}
