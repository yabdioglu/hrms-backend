package kodlamaio.hrms.business.concretes;

import java.util.List;

import kodlamaio.hrms.dataAccess.abstracts.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.abstracts.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	public UserManager (UserDao userDao, UserRepository userRepository) {
		this.userDao = userDao;
		this.userRepository = userRepository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	
	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Data listed.");
	}
	
	public Result existsByEmail(String email) {
		if (userDao.existsByEmail(email)) {
			return new ErrorResult("The email address is used.");
		}
		return new SuccessResult();
	}

	@Override
	public void save(User user) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		System.out.println(user.getPassword());
		userRepository.save(user);
	}


}
