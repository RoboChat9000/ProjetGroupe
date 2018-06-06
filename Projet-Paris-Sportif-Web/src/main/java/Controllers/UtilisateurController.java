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
		System.out.println("[sysout au niveau de AccountController]" + utilisateur);
		return "Accueil";
	}
}
	