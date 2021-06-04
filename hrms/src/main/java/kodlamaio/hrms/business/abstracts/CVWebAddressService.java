package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CVWebAddress;

public interface CVWebAddressService {
	Result add(CVWebAddress cvWebAddress);
	DataResult<List<CVWebAddress>> getAll();
}
