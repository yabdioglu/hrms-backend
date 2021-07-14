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

import kodlamaio.hrms.business.abstracts.CVLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CVLanguage;
import kodlamaio.hrms.entities.dtos.CVLanguageSetDto;

@RestController
@RequestMapping("/api/cvLanguage")
@CrossOrigin
public class CVLanguagesController {

	private CVLanguageService cvLanguageService;
	
	@Autowired
	public CVLanguagesController(CVLanguageService cvLanguageService) {
		this.cvLanguageService = cvLanguageService;
	}
	
	@GetMapping("/getByCurriculumId")
	public DataResult<List<CVLanguage>> getByCurriculumId(@RequestParam int curriculumId){
		return this.cvLanguageService.getByCurriculumVitaeId(curriculumId);
	}
	
	
	@PostMapping("/addLanguage")
    public Result addLanguage(@RequestBody CVLanguageSetDto cvLanguageSetDto){
        return this.cvLanguageService.addLanguage(cvLanguageSetDto);
    }
	
	@DeleteMapping("/deleteLanguage")
    public Result deleteLanguage(@RequestParam int languageId){
        return this.cvLanguageService.deleteLanguage(languageId);
    }
}
