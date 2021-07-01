package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<JobAdvertisement> getByJobAdvertisementId(int jobAdvertisementId);
	
	DataResult<List<JobAdvertisementDto>> getByIsActiveTrueAndEmployer_CompanyName(String companyName);
	DataResult<List<JobAdvertisementDto>> getByIsActiveTrueOrderByCreatedDate();
	DataResult<List<JobAdvertisementDto>> getAdvertisementWithEmployerDetails();
	Result getIsActivity(int jobAdvertisementId);
	

}
