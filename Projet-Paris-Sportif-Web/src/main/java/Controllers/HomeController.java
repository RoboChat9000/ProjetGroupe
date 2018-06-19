package Controllers;


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

import DAO_JPA.IDAOCote;
import DAO_JPA.IDAOMatch;
import DAO_JPA.IDAOPari;
import fr.formation.model.Pari;




@Controller
public class HomeController {

	@Autowired
	private IDAOMatch daoMatch;
	
	@Autowired
	private IDAOCote daoCote;
	
	@Autowired
	private IDAOPari daoPari;
	
/*	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	binder.addValidators(new PariValidator());
	}*/
	
@GetMapping(value={"/Accueil"})
public String accueil(Model model) {
	model.addAttribute("matches", daoMatch.findAll());
return "Accueil";
}

@GetMapping(value={"/Parier" })
public String parier(@RequestParam("id") int id, Model model){
	model.addAttribute("match", daoMatch.findById(id));

	model.addAttribute("cote", daoCote.findById(id).get());

  	return "Parier";
}
@PostMapping(value={"/Parier" })
public String parier(@Valid @ModelAttribute Pari pari, BindingResult result) {

/*		if (result.hasErrors()) {
			return "Parier";
			}*/
/*	daoPari.save(pari);*/
		
	  	return "redirect:/Accueil";
	}




	

}