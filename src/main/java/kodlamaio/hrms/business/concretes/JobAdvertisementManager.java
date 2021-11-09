package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	
	
	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "Job Advertisements listed");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job Advertisement added");
	}


	@Override
	public DataResult<List<JobAdvertisementDto>> getByIsActiveTrueAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getByIsActiveTrueAndCompanyName(companyName), "Job Advertisements listed");
	}


	@Override
	public DataResult<List<JobAdvertisementDto>> getByIsActiveTrueOrderByCreatedDate() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getByIsActiveTrueOrderByCreatedDate(), "Active job advertisement were listed by date of creation.");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getAdvertisementWithEmployerDetails() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getAdvertisementWithEmployerDetails(), "Data listed.");
	}

	@Override
	public Result getIsActivity(int jobAdvertisementId) {
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.getOne(jobAdvertisementId);
		jobAdvertisement.setActive(!jobAdvertisement.isActive());;
		this.jobAdvertisementDao.save(jobAdvertisement);
		if(jobAdvertisement.isActive()) {
			return new SuccessResult("The ad has been activated.");
		}
		return new SuccessResult("The ad has been inactivated.");
	}


	@Override
	public DataResult<JobAdvertisement> getByJobAdvertisementId(int jobAdvertisementId) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.findById(jobAdvertisementId).get(), "The specific company's job ads were listed.");
	}


	@Override
	public Result confirmJobAd(int jobAdvertisementId) {
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.getOne(jobAdvertisementId);
		jobAdvertisement.setConfirmed(true);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job advertisement confirmed.");
	}


	@Override
	public DataResult<List<JobAdvertisement>> getByConfirmed() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrueAndIsConfirmedTrue(), "Job Advertisements listed.");
	}
}
