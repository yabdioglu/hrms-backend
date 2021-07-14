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

import kodlamaio.hrms.business.abstracts.CVExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CVExperience;
import kodlamaio.hrms.entities.dtos.CVExperienceAddDto;

@RestController
@RequestMapping("/api/cvExperiences")
@CrossOrigin
public class CVExperiencesController {
	private CVExperienceService cvExperienceService;
	
	@Autowired
	public CVExperiencesController(CVExperienceService cvExperienceService) {
		this.cvExperienceService = cvExperienceService;
	}
	
	@GetMapping("/getByCurriculumId")
	public DataResult<List<CVExperience>> getByCurriculumId(@RequestParam int curriculumId){
		return this.cvExperienceService.getByCurriculumVitaeId(curriculumId);
	}
	
	@PostMapping("/addExperience")
    public Result addExperience(@RequestBody CVExperienceAddDto cvExperienceAddDto){
        return this.cvExperienceService.addExperience(cvExperienceAddDto);
    }
	
	@DeleteMapping("/deleteExperience")
    public Result deleteExperience(@RequestParam int experienceId){
        return this.cvExperienceService.deleteExperience(experienceId);
    }

}
