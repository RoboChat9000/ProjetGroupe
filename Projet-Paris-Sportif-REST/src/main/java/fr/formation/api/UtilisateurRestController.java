package fr.formation.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.dao.IDAOLigue;
import fr.formation.dao.IDAOUtilisateur;
import fr.formation.model.Ligue;
import fr.formation.model.Utilisateur;
import fr.formation.model.Views.UtilisateurView;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/")
public class UtilisateurRestController {

	@Autowired
	IDAOLigue IDAOLig;

	@Autowired
	IDAOUtilisateur IDAOUtil;

	@JsonView(UtilisateurView.class)
	 @GetMapping("") public List<Utilisateur> GetLogin() {
	 return IDAOUtil.findAll(); }
	 
	@JsonView(UtilisateurView.class)
	 @GetMapping("inscription/{pseudo}") public Boolean verifPseudo(@PathVariable String pseudo) {
		
		if(IDAOUtil.findByPseudo(pseudo) != null)
		{
			return false;
		} else {
			return true;
		}
		
	  }
	
	
	
	
	
	 @JsonView(UtilisateurView.class)
	 @PostMapping("login/")
	 public Utilisateur PostLogin(@RequestBody Utilisateur utilisateur)
	 {
		
		 Utilisateur utilisateurTransient = new Utilisateur();
		 utilisateurTransient = IDAOUtil.findByPseudo(utilisateur.getPseudo());
		 
		 if(IDAOUtil.findByPseudo(utilisateur.getPseudo())!=null)
		 {
		 if(utilisateur.getMdp().equals(IDAOUtil.findByPseudo(utilisateur.getPseudo()).getMdp()))
		 {
			return utilisateurTransient;
		 }
		 else
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//			 utilisateurTransient.setPseudo(utilisateur.getPseudo());
//			 return utilisateurTransient;
		 }
		 else {
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		 }
	 }
	
	 
	@JsonView(UtilisateurView.class)
	@GetMapping("inscription/")
	public List<Utilisateur> GetInscription() {
		return IDAOUtil.findAll();
	}
	
	
	 @PostMapping("inscription/")
	 public Utilisateur PostInscription(@RequestBody Utilisateur utilisateur)
	 {
		 if (IDAOUtil.findByPseudo(utilisateur.getPseudo()) == null)
		 {
	IDAOUtil.save(utilisateur);
	return IDAOUtil.findByPseudo(utilisateur.getPseudo());
		 }
		 else 
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	 }

	
}
