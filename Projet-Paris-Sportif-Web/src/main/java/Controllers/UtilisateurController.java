package Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DAO_JPA.IDAOUtilisateur;
import data.Utilisateur;

@Controller
public class UtilisateurController {

	@Autowired
	IDAOUtilisateur IDAOUtil;
	
	
	@GetMapping("/Connexion")
	public String GetLogin(Model model)
	{
		//model.addAttribute("utilisateur", new Utilisateur());
		return "Connexion";
	}
	
	@PostMapping("/Connexion")
	public String PostLogin(@ModelAttribute("utilisateur") Utilisateur utilisateur, Model model, HttpSession session)
	{

		session.setAttribute("utilisateur", utilisateur);
		System.out.println("[sysout au niveau du PostLogin de UtilisateurController]" + utilisateur);
		return "Accueil";
	}
	
	@GetMapping("/Inscription")
	public String GetInscription(Model model)
	{
		return "/Inscription";
	}
	
	@PostMapping("/Inscription")
	public String PostInscription(Model model, @ModelAttribute("utilisateur") Utilisateur utilisateur, HttpSession session)
	{
		session.setAttribute("utilisateur", utilisateur);
		System.out.println("[sysout au niveau du PostInscription de UtilisateurController]" + utilisateur);
		return "/Accueil";
	}
}
	