package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class AuthManager implements AuthService{

	private CandidateDao candidateDao;
	private EmployerDao employerDao;
	private EmployeeDao employeeDao;
	
	@Autowired
	public AuthManager(CandidateDao candidateDao, EmployerDao employerDao, EmployeeDao employeeDao) {
		this.candidateDao = candidateDao;
		this.employerDao = employerDao;
		this.employeeDao = employeeDao;
	}

	@Override
	public Result registerCandidate(Candidate candidate) {
		if(this.candidateDao.existsByEmail(candidate.getEmail())) {
			return new ErrorResult("Email kullanılmaktadır.");
		}
		this.candidateDao.save(candidate);
		return new SuccessResult("İş arayan kayıt edildi.");
	}

	@Override
	public Result registerEmployer(Employer employer) {
		if(this.employerDao.existsByEmail(employer.getEmail())) {
			return new ErrorResult("Email kullanılmaktadır.");
		}
		this.employerDao.save(employer);
		return new SuccessResult("İş veren kayıt edildi.");
	}

	@Override
	public Result registerEmployee(Employee employee) {
		if(this.employeeDao.existsByEmail(employee.getEmail())) {
			return new ErrorResult("Email kullanılmaktadır.");
		}
		this.employeeDao.save(employee);
		return new SuccessResult("Sistem çalışanı kayıt edildi.");
	}
	
	

}
