package fr.formation.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.dao.IDAOLigue;
import fr.formation.dao.IDAOUtilisateur;
import fr.formation.model.Ligue;
import fr.formation.model.Utilisateur;
import fr.formation.model.Views.UtilisateurView;

@RestController
@RequestMapping("/")
public class UtilisateurRestController {

	@Autowired
	IDAOLigue IDAOLig;

	@Autowired
	IDAOUtilisateur IDAOUtil;

	
	 @GetMapping("") public List<Utilisateur> GetLogin() {
	 return IDAOUtil.findAll(); }
	 

	// @PostMapping("")
	// public void PostLogin(@RequestBody Utilisateur utilisateur)
	// {
	//
	// }
	//
	 
	@JsonView(UtilisateurView.class)
	@GetMapping("inscription")
	public List<Utilisateur> GetInscription() {
		return IDAOUtil.findAll();
	}
	
	
	 @PostMapping("inscription")
	 public void PostInscription(@RequestBody Utilisateur utilisateur)
	 {
	IDAOUtil.save(utilisateur);
	 }

	
}
