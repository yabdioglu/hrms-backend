package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

import javax.sql.rowset.BaseRowSet;

@Service
public class AuthManager implements AuthService{

	private EmployerService employerService;
	private CandidateService candidateService;
	private EmployeeService employeeService;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public AuthManager(EmployerService employerService, CandidateService candidateService,
			EmployeeService employeeService) {
		super();
		this.employerService = employerService;
		this.candidateService = candidateService;
		this.employeeService = employeeService;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	@Override
	public Result registerCandidate(Candidate candidate) {
		candidate.setPassword(this.passwordEncoder.encode(candidate.getPassword()));
		return this.candidateService.add(candidate);

	}

	@Override
	public Result registerEmployer(Employer employer) {
		employer.setPassword(this.passwordEncoder.encode(employer.getPassword()));
		return this.employerService.add(employer);
	}

	@Override
	public Result registerEmployee(Employee employee) {
		employee.setPassword(this.passwordEncoder.encode(employee.getPassword()));
		return this.employeeService.add(employee);
	}
	

	
	

}
