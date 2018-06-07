package Controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DAO_JPA.IDAOPari;
import data.Pari;
import data.PariId;


@Controller
public class MatchController {

	
	@Autowired
	IDAOPari daoPari;
	
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new DatePariValidator());
	}
	
	@GetMapping("/match")
	public String getMatch(Model model, 
							@RequestParam int idMatch,
							HttpSession session)
	{
		//int idUtilisateur = (Integer)((Utilisateur)session.getAttribute("utilisateur")).getId();
		//Pari pari = daoPari.findById(new PariId(idUtilisateur, idMatch)).get();
		//
		Pari pari = daoPari.findById(new PariId(1, idMatch)).get();
		
		List<Pari> listPari = daoPari.findByLigue(1);
		model.addAttribute("listPari", listPari);
		model.addAttribute("pari", pari);
		
		return "match";
	}
	
	
	@PostMapping("/match")
	public String getMatch(Model model,
							@Valid @ModelAttribute Pari pariUtil,
							BindingResult result,
							@RequestParam int idMatch,
							@RequestParam int resultatDom,
							@RequestParam int resultatExt,
							HttpSession session
							)
	{
		//int idUtilisateur = (Integer)((Utilisateur)session.getAttribute("utilisateur")).getId();
		//Pari pari = daoPari.findById(new PariId(idUtilisateur, idMatch)).get();
		//
		
		Pari pari = daoPari.findById(new PariId(1, 1)).get();
		
		if(result.hasErrors()) {
			model.addAttribute("idMatch", idMatch);
			return "redirect:/match";
		}

		pari.setResultatDom(resultatDom);
		pari.setResultatExt(resultatExt);
		
		
		
//		
//		SimpleDateFormat d = new SimpleDateFormat ("dd/MM/yyyy hh:mm" );
//		String date = d.format(currentTime);
//		System.out.println(date);
		
		
		daoPari.save(pari);
		return "Accueil";
	}
	
}
