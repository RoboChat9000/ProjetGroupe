package Controllers;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import data.Pari;


public class PariValidator implements Validator {

//@Override
	public boolean supports(Class<?> cls) {
	return Pari.class.equals(cls);
	}
//@Override
	public void validate(Object obj, Errors e) {
	ValidationUtils.rejectIfEmptyOrWhitespace(e, "resultatDom", "resultatDom.empty", "Le score de la premi�re �quipe doit �tre saisi");
	ValidationUtils.rejectIfEmptyOrWhitespace(e, "resultatExt", "resultatExt.empty", "Le score de la seconde �quipe doit �tre saisi");
}
}