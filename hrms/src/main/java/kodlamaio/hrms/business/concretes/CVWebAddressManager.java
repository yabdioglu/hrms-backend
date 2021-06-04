package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kodlamaio.hrms.business.abstracts.CVWebAddressService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CVWebAddressDao;
import kodlamaio.hrms.entities.concretes.CVWebAddress;

@Component
public class CVWebAddressManager implements CVWebAddressService {
	private CVWebAddressDao cvWebAddressDao;
	
	@Autowired
	public CVWebAddressManager(CVWebAddressDao cvWebAddressDao) {
		super();
		this.cvWebAddressDao = cvWebAddressDao;
	}
	@Override
	public Result add(CVWebAddress cvWebAddress) {
		this.cvWebAddressDao.save(cvWebAddress);
		return new SuccessResult("Web adresi başarıyla eklendi.");
	}

	@Override
	public DataResult<List<CVWebAddress>> getAll() {
		return new SuccessDataResult<List<CVWebAddress>>(this.cvWebAddressDao.findAll(),"Web adresleri listelendi.");
	}

}
