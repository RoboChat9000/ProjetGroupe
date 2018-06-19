package fr.formation.api;

import java.text.DateFormat;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import fr.formation.dao.IDAOUtilisateur;
import fr.formation.model.Utilisateur;



public class UtilisateurValidator implements Validator {
	

	
		 public boolean supports(Class<?> cls) {
		return Utilisateur.class.equals(cls);
		}
		 
		 public void validateMdpConnexion(Utilisateur u, Errors e, IDAOUtilisateur IDAOUtil)
		 {
			//validation of password in connexion form
				
				if(!u.getMdp().equals(IDAOUtil.findByPseudo(u.getPseudo()).getMdp()))
				{
					e.rejectValue("mdp", "wrong.mdp", "mot de passe invalide");
				}
		 }
		 
		 
		 public void validatePseudoInscription(Utilisateur u, Errors e, IDAOUtilisateur IDAOUtil)
		 {
			for(int i=0; i<IDAOUtil.findAll().size();i++)
			{
				if(u.getPseudo().equals(IDAOUtil.findAll().get(i).getPseudo()))
				{
					e.rejectValue("pseudo", "pseudo.deja.pris", "pseudo vide ou deja pris");
				}
			}
			 
		 }
		 
		 public void validateMailInscription(Utilisateur u, Errors e, IDAOUtilisateur IDAOUtil)
		 {
			for(int i=0; i<IDAOUtil.findAll().size();i++)
			{
				if(u.getMail().equals(IDAOUtil.findAll().get(i).getMail()))
				{
					e.rejectValue("mail", "Mail.deja.pris", "Mail vide ou deja pris");
				}
			}
			 
		 }
		 
		 
		 public void validateMdpInscription(Utilisateur u, Errors e, String mdpConf)
		 {
			//validation of password in inscription form
		
				if(!u.getMdp().equals(mdpConf))
				{
					e.rejectValue("mdp", "different.mdp", "les mots de passe sont diff�rents");
				}
		 }
		 
		 public void validateConnexion(Object obj, Errors e) {
				ValidationUtils.rejectIfEmptyOrWhitespace(e, "pseudo", "pseudo.empty", "Le pseudo doit �tre saisi");
				ValidationUtils.rejectIfEmptyOrWhitespace(e, "mdp", "mdp.empty", "Le mdp doit �tre saisi");	
				}
		 
//		 public void validateInscriptionDate(Utilisateur u, Object obj, Errors e)
//		 {
//			 DateFormat.getDateInstance()
//			 if(!u.getDateNaissance().get)
//		 }
		 
		 public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "pseudo", "pseudo.empty", "Le pseudo doit �tre saisi");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "mdp", "mdp.empty", "Le mdp doit �tre saisi");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "dateNaissance", "dateNaissance.empty", "La dateNaissance doit �tre saisi");		
		}
		 
		public ExecutableValidator forExecutables() {
			// TODO Auto-generated method stub
			return null;
		}
		public BeanDescriptor getConstraintsForClass(Class<?> arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		public <T> T unwrap(Class<T> arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		public <T> Set<ConstraintViolation<T>> validate(T arg0, Class<?>... arg1) {
			// TODO Auto-generated method stub
			return null;
		}
		public <T> Set<ConstraintViolation<T>> validateProperty(T arg0, String arg1, Class<?>... arg2) {
			// TODO Auto-generated method stub
			return null;
		}
		public <T> Set<ConstraintViolation<T>> validateValue(Class<T> arg0, String arg1, Object arg2,
				Class<?>... arg3) {
			// TODO Auto-generated method stub
			return null;
		}
		}

