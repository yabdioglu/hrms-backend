package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.TalentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Talent;

@RestController
@RequestMapping("/api/talents")
@CrossOrigin
public class TalentsController {
	
	private TalentService talentService;
	
	@Autowired
	public TalentsController(TalentService talentService) {
		this.talentService = talentService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Talent>> getAll(){
		return this.talentService.getAll();
	}

}