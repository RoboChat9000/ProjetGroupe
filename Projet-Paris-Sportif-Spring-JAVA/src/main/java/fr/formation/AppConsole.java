package fr.formation;

import org.springframework.beans.factory.annotation.Autowired;

import DAO_JPA.IDAOMatch;
import DAO_JPA.IDAOPari;
import DAO_JPA.IDAOUtilisateur;
import fr.formation.model.Pari;
import fr.formation.model.PariId;

public class AppConsole
{
	@Autowired
	private IDAOUtilisateur IDAOUti;
	@Autowired
	private IDAOPari IDAOPari;
	@Autowired
	private IDAOMatch IDAOMat;
	
	
	@Autowired
	private IDAOUtilisateur IDAOUtil;
	
	
	public void run(String[] args) {
//		System.out.println(IDAOPari.findByUtilisateurAndMatch(IDAOUtil.findById(1),IDAOMatch.findById(1)));
//		System.out.println(IDAOMat.findAll());
		Pari pari = IDAOPari.findById(new PariId(1,1)).get();
		System.out.println(pari.getMatch().getId());
		pari.setResultatDom(33);
		IDAOPari.save(pari);
//System.out.println(IDAOUtil.findById(1));
	
//	IDAOUti.rejoinLigue(1, 1);
	}
}