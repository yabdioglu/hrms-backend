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
	public DataResult<List<JobAdvertisementDto>> getAll() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getAll(), "Tüm iş ilanları listelendi.");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı eklendi.");
	}


	@Override
	public DataResult<List<JobAdvertisementDto>> getByIsActiveTrueAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getByIsActiveTrueAndCompanyName(companyName), "Belirli şirketin aktif iş ilanları listelendi.");
	}


	@Override
	public DataResult<List<JobAdvertisementDto>> getByIsActiveTrueOrderByCreatedDate() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getByIsActiveTrueOrderByCreatedDate(), "Aktif iş ilanları oluşturulma tarihine göre listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getAdvertisementWithEmployerDetails() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getAdvertisementWithEmployerDetails(), "Data listelendi.");
	}

	@Override
	public Result getIsActivity(int jobAdvertisementId) {
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.getOne(jobAdvertisementId);
		jobAdvertisement.setActive(!jobAdvertisement.isActive());;
		this.jobAdvertisementDao.save(jobAdvertisement);
		if(jobAdvertisement.isActive()) {
			return new SuccessResult("İlan aktif duruma getirildi.");
		}
		return new SuccessResult("İlan pasif duruma getirildi.");
	}
}
