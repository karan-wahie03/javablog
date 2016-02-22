package cz.karan.jba.annonation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cz.karan.jba.repository.UseRepository;

public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String>{

	@Autowired 
	private UseRepository userrepository;
	
	@Override
	public void initialize(UniqueUserName constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(userrepository==null){
			return true;
		}
		return userrepository.findByName(value)==null;
	}

}
