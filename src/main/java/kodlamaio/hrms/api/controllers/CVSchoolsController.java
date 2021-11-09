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

import kodlamaio.hrms.business.abstracts.CVSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CVSchool;
import kodlamaio.hrms.entities.dtos.CVSchoolAddDto;

@RestController
@RequestMapping("/api/cvSchools")
@CrossOrigin
public class CVSchoolsController {
	private CVSchoolService cvSchoolService;
	
	@Autowired
	public CVSchoolsController(CVSchoolService cvSchoolService) {
		this.cvSchoolService = cvSchoolService;
	}
	
	@GetMapping("/getByCurriculumId")
	public DataResult<List<CVSchool>> getByCurriculumId(@RequestParam int curriculumId){
		return this.cvSchoolService.getByCurriculumVitaeId(curriculumId);
	}
	
	@PostMapping("/addSchool")
    public Result addSchool(@RequestBody CVSchoolAddDto cvSchoolAddDto){
        return this.cvSchoolService.addSchool(cvSchoolAddDto);
    }
	
	@DeleteMapping("/deleteSchool")
    public Result deleteSchool(@RequestParam int schoolId){
        return this.cvSchoolService.deleteSchool(schoolId);
    }

}
