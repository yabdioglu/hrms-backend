package kodlamaio.hrms.core.adapters;



import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class MernisServiceAdapter implements UserCheckService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		return true;
	}
}
