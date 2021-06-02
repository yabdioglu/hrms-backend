package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer_CompanyName(String companyName);
	DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByCreatedDate();
	// TODO : isActive
	
	Result getIsActivity(int jobAdvertisementId);
	
	DataResult<List<JobAdvertisementDto>> getAdvertisementWithEmployerDetails();
	

}
