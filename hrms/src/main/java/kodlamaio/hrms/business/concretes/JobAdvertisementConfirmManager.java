package kodlamaio.hrms.business.concretes;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementConfirmService;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementConfirmDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisementConfirm;
import kodlamaio.hrms.entities.dtos.JobAdConfirmDto;

@Service
public class JobAdvertisementConfirmManager implements JobAdvertisementConfirmService{

	private JobAdvertisementConfirmDao jobAdvertisementConfirmDao;
	private JobAdvertisementService jobAdvertisementService;
	private final ModelMapper modelMapper;
	
	@Autowired
	public JobAdvertisementConfirmManager(JobAdvertisementConfirmDao jobAdvertisementConfirmDao, JobAdvertisementService jobAdvertisementService, ModelMapper modelMapper) {
		this.jobAdvertisementConfirmDao = jobAdvertisementConfirmDao;
		this.jobAdvertisementService = jobAdvertisementService;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public Result confirm(JobAdConfirmDto jobAdvertisementConfirmDto) {
		JobAdvertisementConfirm jobAdvertisementConfirm = modelMapper.map(jobAdvertisementConfirmDto, JobAdvertisementConfirm.class);
		this.jobAdvertisementConfirmDao.save(jobAdvertisementConfirm);
		int jobAdvertisementId = jobAdvertisementConfirm.getJobAdvertisement().getJobAdvertisementId();
		jobAdvertisementService.confirmJobAd(jobAdvertisementId);
		return new SuccessResult("Job advertisement confirmed");
	}

}
