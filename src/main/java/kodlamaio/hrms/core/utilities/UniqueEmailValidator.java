package kodlamaio.hrms.core.utilities;

import kodlamaio.hrms.dataAccess.abstracts.UserRepository;
import kodlamaio.hrms.entities.abstracts.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        User user = userRepository.findByEmail(email);
        if(user != null){
            return false;
        }
        return true;
    }
}
