package Controllers;

import java.util.List;
import java.util.function.Predicate;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DAO_JPA.IDAOLigue;
import DAO_JPA.IDAOUtilisateur;
import fr.formation.model.Ligue;
import fr.formation.model.Utilisateur;

@Controller
public class LigueController {

	@Autowired
	IDAOLigue IDAOLig;
	@Autowired
	IDAOUtilisateur IDAOUtil;
	
	
	
	@GetMapping("/ligue")
	public String GetLigue(Model model, HttpSession session)
	{ 
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		System.out.println(utilisateur);
		List<Ligue> listeDesLiguesDuUser = utilisateur.getListLigue();
		List<Ligue> listeDesLigues = IDAOLig.findAll();
		
		//System.out.println(IDAOLig.findAll().get(0).getListUtilisateur());
		
		listeDesLiguesDuUser.forEach((ligue) -> listeDesLigues.removeIf((la) -> la.getId() == ligue.getId()));
		
		
//		listeDesLigues.removeAll(listeDesLiguesDuUser);
		System.out.println(listeDesLigues);
		 model.addAttribute("listeDesLigues", listeDesLigues);
		 model.addAttribute("listeDesLiguesDuUser", listeDesLiguesDuUser);
		 
		return "/ligue";
	}
	
	
	@PostMapping("/ligue")
	public String PostLigue(@RequestParam("listeDesLigues") List<Ligue> listeDesLigues, @RequestParam("listeDesLiguesDuUser") List<Ligue> listeDesLiguesDuUser, @RequestParam("id") int id, @ModelAttribute("utilisateur") Utilisateur utilisateur, Model model, HttpSession session)
	{ 
		Ligue laLigueARejoindre = (IDAOLig.findById(id).get());
		listeDesLiguesDuUser.add(laLigueARejoindre);
		listeDesLiguesDuUser.forEach((ligue) -> listeDesLigues.removeIf((la) -> la.getId() == ligue.getId()));
		return "/ligue";
	}
}
