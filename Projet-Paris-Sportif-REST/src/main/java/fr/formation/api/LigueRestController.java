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
import fr.formation.model.Views.LigueView;

@RestController
@RequestMapping("/ligue")
public class LigueRestController {

	@Autowired
	IDAOLigue IDAOLig;
	@Autowired
	IDAOUtilisateur IDAOUtil;
	
	
	@JsonView(LigueView.class)
	@GetMapping("")
	public List<Ligue> GetLigue()
	{ 
		return IDAOLig.findAll();
	}
	
	
	@JsonView(LigueView.class)
	@PostMapping("/utilisateur/{idUtil}/ligue/{idLig}")
	public void PostLigueAjouter(@PathVariable Integer idUtil, @PathVariable Integer idLig)
	{ 
//		System.out.println("findAll trouve-t-il la liste des utilisateur?" + IDAOLig.findAll().get(0).getListUtilisateur());
		
		Optional <Utilisateur> utiBDD = IDAOUtil.findById(idUtil);
		
		if(utiBDD.isPresent())
		{
			Optional <Ligue> ligBDD = IDAOLig.findById(idLig);
			if (ligBDD.isPresent())
			{
				utiBDD.get().getListLigue().add(ligBDD.get());
				IDAOUtil.save(utiBDD.get());
			}
		}		
		
	}
	
	@DeleteMapping("/utilisateur/{idUser}/ligue/{idLigue}")
	public void removeLigueFromUtilisateur(@PathVariable Integer idUser, @PathVariable Integer idLigue) {
		Optional<Utilisateur> user = IDAOUtil.findById(idUser);
		
		if(user.isPresent()) {
			Optional<Ligue> ligue = IDAOLig.findById(idLigue);
			
			if(ligue.isPresent()) {
				user.get().getListLigue().remove(ligue.get());
				IDAOUtil.save(user.get());
			}
		}
	}
	
}
