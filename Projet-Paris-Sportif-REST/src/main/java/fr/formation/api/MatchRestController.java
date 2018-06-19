package fr.formation.api;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.dao.IDAOMatch;
import fr.formation.dao.IDAOPari;
import fr.formation.model.Match;
import fr.formation.model.Pari;
import fr.formation.model.PariId;
import fr.formation.model.Utilisateur;
import fr.formation.model.Views;

@RestController
@RequestMapping("/match")
public class MatchRestController {

	@Autowired
	IDAOPari daoPari;
	
	@Autowired
	IDAOMatch daoMatch;
	
	@GetMapping("")
	@ResponseBody
	@JsonView(Views.MatchView.class)  
	public List<Match> list() {
		return daoMatch.findAll();
	}
	
	
	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.MatchView.class)
	public Pari find(@PathVariable Integer id, HttpSession session) {
		
		Utilisateur utilisateur = (Utilisateur)session.getAttribute("utilisateur");
		//int idUtilisateur = utilisateur.getId();
		
		
		Optional<Pari> pari =  daoPari.findById(new PariId(1, id));

		if(pari.isPresent()) {
			return pari.get();
		} else if(id <= 64 && id > 0){
			Match match = daoMatch.findById(id).get();
			Pari newPari = new Pari(utilisateur, match, 0, 0);
			return newPari;
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le pari n'a pas été trouvé");
		}
	}
	
	
	@PostMapping("/{id}")
	public void create(@RequestBody Pari pari) {
		daoPari.save(pari);
	}
	
	
	@PutMapping("/{id}")
	public void update(@RequestBody Pari pari) {
		daoPari.save(pari);
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id, HttpSession session) {
		
		Utilisateur utilisateur = (Utilisateur)session.getAttribute("utilisateur");
		//int idUtilisateur = utilisateur.getId();
		
		daoPari.deleteById(new PariId(1,id));
	}
}
