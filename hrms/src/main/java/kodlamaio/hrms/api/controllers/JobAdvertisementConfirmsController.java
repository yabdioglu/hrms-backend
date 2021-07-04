package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementConfirmService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.JobAdConfirmDto;

@RestController
@RequestMapping("/api/jobAdvertisementconfirms")
@CrossOrigin
public class JobAdvertisementConfirmsController {
	private JobAdvertisementConfirmService jobAdvertisementConfirmService;

	@Autowired
	public JobAdvertisementConfirmsController(JobAdvertisementConfirmService jobAdvertisementConfirmService) {
		this.jobAdvertisementConfirmService = jobAdvertisementConfirmService;
	}
	
	@PostMapping("/confirmJobAdvertisement")
	public Result addJobAdvertisements(@RequestBody JobAdConfirmDto jobAdvertisementConfirm) {
		return this.jobAdvertisementConfirmService.confirm(jobAdvertisementConfirm);
	}
	
}
