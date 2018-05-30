package fr.formation;

import org.springframework.beans.factory.annotation.Autowired;

import DAO_JPA.IDAOMatch;
import DAO_JPA.IDAOPari;
import DAO_JPA.IDAOUtilisateur;

public class AppConsole
{
	@Autowired
	private IDAOUtilisateur IDAOUti;
	@Autowired
	private IDAOPari IDAOPari;
	@Autowired
	private IDAOMatch IDAOMat;
	
	@Autowired
	private IDAOMatch IDAOMatch;
	
	@Autowired
	private IDAOUtilisateur IDAOUtil;
	
	
	public void run(String[] args) {
		System.out.println(IDAOPari.findByUtilisateurAndMatch(IDAOUtil.findById(1),IDAOMatch.findById(1)));
		
	}
}