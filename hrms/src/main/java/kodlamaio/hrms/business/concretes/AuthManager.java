package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class AuthManager implements AuthService{

	private EmployerService employerService;
	private CandidateService candidateService;
	private EmployeeService employeeService;
	
	@Autowired
	public AuthManager(EmployerService employerService, CandidateService candidateService,
			EmployeeService employeeService) {
		super();
		this.employerService = employerService;
		this.candidateService = candidateService;
		this.employeeService = employeeService;
	}

	@Override
	public Result registerCandidate(Candidate candidate) {
		if(!candidate.getPassword().equals(candidate.getConfirmPassword())) {
			return new ErrorResult("Passwords don't match!");
		}
		return this.candidateService.add(candidate);
	}

	@Override
	public Result registerEmployer(Employer employer) {
		if(!employer.getPassword().equals(employer.getConfirmPassword())) {
			return new ErrorResult("Passwords don't match!");
		}
		return this.employerService.add(employer);
	}

	@Override
	public Result registerEmployee(Employee employee) {
		if(!employee.getPassword().equals(employee.getConfirmPassword())) {
			return new ErrorResult("Passwords don't match!");
		}
		return this.employeeService.add(employee);
	}
	

	
	

}
