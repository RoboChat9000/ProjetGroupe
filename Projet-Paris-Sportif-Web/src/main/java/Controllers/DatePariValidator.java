package Controllers;

import java.util.Date;

import javax.validation.Validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import data.Pari;

public class DatePariValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return Pari.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		
	}
	
	public void validateDate(Object target, Errors errors, Date dateActuelle, Date datePari) {
		dateActuelle = new Date();
		if(dateActuelle.compareTo(datePari) < 0) {
			errors.rejectValue("date", "erreurDate", "le match a déjà commencé !");
		}
	}

	
}
