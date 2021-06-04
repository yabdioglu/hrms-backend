package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisementDto>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	@PostMapping("/addJobAdvertisements")
	public Result addJobAdvertisements(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getByCompanyName")
	public DataResult<List<JobAdvertisementDto>> getByCompanyName(@RequestParam String companyName){
		return this.jobAdvertisementService.getByIsActiveTrueAndEmployer_CompanyName(companyName);
	}
	
	@GetMapping("/getIsActiveAndOrderCreatedDate")
	public DataResult<List<JobAdvertisementDto>> getIsActiveAndOrderCreatedDate(){
		return this.jobAdvertisementService.getByIsActiveTrueOrderByCreatedDate();
	}
	
	@PostMapping("/IsActive")
	public Result IsActive(@RequestParam int jobAdvertisementId) {
		return this.jobAdvertisementService.getIsActivity(jobAdvertisementId);
	}
	
	@GetMapping("/getAllIsActive")
	public DataResult<List<JobAdvertisementDto>> getAllIsActive() {
		return this.jobAdvertisementService.getAdvertisementWithEmployerDetails();
	}
	

}
