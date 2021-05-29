package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private AuthService authService;
	
	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
	@PostMapping("/registerCandidate")
	public Result registerCandidate(@Valid @RequestBody Candidate candidate) {
		return this.authService.registerCandidate(candidate);
	}
	
	@PostMapping("/registerEmployer")
	public Result registerEmployer(@Valid @RequestBody Employer employer) {
		return this.authService.registerEmployer(employer);
	}
	
	@PostMapping("/registerEmployee")
	public Result registerEmployee(@Valid @RequestBody Employee employee) {
		return this.authService.registerEmployee(employee);
	}
	
	
	

}
