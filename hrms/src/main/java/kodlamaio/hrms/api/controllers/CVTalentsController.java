package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CVTalentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CVTalent;
import kodlamaio.hrms.entities.dtos.CVTalentSetDto;

@RestController
@RequestMapping("/api/cvTalents")
@CrossOrigin
public class CVTalentsController {
	private CVTalentService cvTalentService;
	
	@Autowired
	public CVTalentsController(CVTalentService cvTalentService) {
		this.cvTalentService = cvTalentService;
	}
	
	@GetMapping("/getByCurriculumId")
	public DataResult<List<CVTalent>> getByCurriculumId(@RequestParam int curriculumId){
		return this.cvTalentService.getByCurriculumVitaeId(curriculumId);
	}
	
	@PostMapping("/addTalent")
    public Result addTalent(@RequestBody CVTalentSetDto cvTalentSetDto){
        return this.cvTalentService.addTalent(cvTalentSetDto);
    }
	
	@DeleteMapping("/deleteTalent")
    public Result deleteTalent(@RequestParam int talentId){
        return this.cvTalentService.deleteTalent(talentId);
    }

}
