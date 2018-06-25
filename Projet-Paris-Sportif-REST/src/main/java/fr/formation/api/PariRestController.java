package fr.formation.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.dao.IDAOPari;
import fr.formation.dao.IDAOUtilisateur;
import fr.formation.model.Ligue;
import fr.formation.model.Pari;
import fr.formation.model.Utilisateur;
import fr.formation.model.Views;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pari")
public class PariRestController {

	
	@Autowired
	IDAOPari daoPari;
	
	@Autowired
	IDAOUtilisateur daoUtilisateur;
	
	@GetMapping("{id}")
	@ResponseBody
	@JsonView(Views.PariView.class)  
	public List<Pari> list(@PathVariable Integer id, HttpSession session) {
		
		//Utilisateur utilisateur = (Utilisateur)session.getAttribute("utilisateur");
		
		Utilisateur utilisateur = daoUtilisateur.findById(1);
		
		List<Ligue> listLigue = utilisateur.getListLigue();
		List<Pari> newListPari = new ArrayList<Pari>();
		
		for(int i = 0; i<listLigue.size(); i++) {
			int idLigue = listLigue.get(i).getId();
			List<Pari> listPari = daoPari.findByLigue(idLigue, id);
			for(int j = 0; j<listPari.size();j++) {
				newListPari.add(listPari.get(j));
			}
		}
		
		return newListPari;
	}
}
