package Controllers;

import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import DAO_JPA.IDAOPari;
import data.Pari;
import data.PariId;

public class DatePariValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return Pari.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		
	}
	
	public void validateDate(Errors errors, Pari pari) {
		Date dateActuelle = new Date();
		Date dateMatch = pari.getMatch().getDate();
		if(dateActuelle.compareTo(dateMatch) < 0) {
			errors.rejectValue("date", "erreurDatePari", "le match a déjà commencé !");
		}
	}

	
}
