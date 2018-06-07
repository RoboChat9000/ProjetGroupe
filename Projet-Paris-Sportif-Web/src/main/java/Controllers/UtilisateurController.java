package Controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DAO_JPA.IDAOUtilisateur;
import data.Utilisateur;


@Controller
public class UtilisateurController {

	//TO DO
	//refaire la verif mdp connexion
	//garder les valeurs saisies par l'util pour l'inscription
	
	@Autowired
	IDAOUtilisateur IDAOUtil;
	
	
	@GetMapping("/Connexion")
	public String GetLogin(Model model)
	{
		model.addAttribute("utilisateur", new Utilisateur());
		return "Connexion";
	}
	
	@PostMapping("/Connexion")
	public String PostLogin(@ModelAttribute("utilisateur") Utilisateur utilisateur, BindingResult result, Model model, HttpSession session)
	{
		new UtilisateurValidator().validateConnexion(utilisateur, result);
		new UtilisateurValidator().validateMdpConnexion(utilisateur, result, IDAOUtil);
	
		
		if (result.hasErrors()) {
			
			System.out.println(result.getFieldErrors());
			
			System.out.println("ERREUR au niveau du post connexion");
			return "Connexion";
		}
	
		
		
		/*if (result.hasErrors()) {
			System.out.println("pseudo et mdp sont requis (connexion)");
			return "Connexion";
		}
	
		if (result.hasErrors())
		{
			System.out.println("mdp invalide");
			return "Connexion";
		}*/
		
		Utilisateur u = IDAOUtil.findByPseudo(utilisateur.getPseudo());
		session.setAttribute("utilisateur", u);
		System.out.println("[sysout au niveau du PostLogin de UtilisateurController]" + u);
		return "redirect:/ligue";
	}
	
	@GetMapping("/Inscription")
	public String GetInscription(Model model)
	{
		model.addAttribute("utilisateur", new Utilisateur());
		return "/Inscription";
	}
	
	@PostMapping("/Inscription")
	public String PostInscription(@RequestParam("mdpConf") String mdpConf, Model model, @Valid@ModelAttribute("utilisateur") Utilisateur utilisateur, BindingResult result, HttpSession session)
	{
		
//		Date date1 = new Date();
//		try
//		{
//		DateFormat format = new SimpleDateFormat("dd/MM/YYYY");
//		date1 = format.parse(format.format(utilisateur.getDateNaissance()));
//		}
//		catch(Exception e)
//		{
//			System.out.println("erreur parsing date");
//		}
//		System.out.println(date1);
//		model.addAttribute(date1);
		
		new UtilisateurValidator().validate(utilisateur, result);
		new UtilisateurValidator().validateMdpInscription(utilisateur, result, mdpConf);
		new UtilisateurValidator().validateMailInscription(utilisateur, result, IDAOUtil);
		new UtilisateurValidator().validatePseudoInscription(utilisateur, result, IDAOUtil);
		
		
if (result.hasErrors()) {
			
			System.out.println("ERREUR de formulaire inscription");
		
			return "Inscription";
		}
		
		
		
		
		/*
		if (result.hasErrors()) {
			
			System.out.println("pseudo et mdp sont requis (inscription)");
		
			return "Inscription";
		}
		
		if (result.hasErrors()) {
			System.out.println("les mdp doivent etre identiques");
		
			return "Inscription";
		}
		
		if (result.hasErrors()) {
			
			System.out.println("le mail est deja pris");
		
			return "Inscription";
		}
		
		
		if (result.hasErrors()) {
			
			System.out.println("le pseudo est deja pris");
		
			return "Inscription";
		}
		*/
		
		
		session.setAttribute("utilisateur", utilisateur);
		IDAOUtil.save(utilisateur);
		System.out.println("[sysout au niveau du PostInscription de UtilisateurController]" + utilisateur);
		return "redirect:/Accueil";
	}
}
	