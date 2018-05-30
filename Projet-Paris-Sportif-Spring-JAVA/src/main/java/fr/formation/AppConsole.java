package fr.formation;

import org.springframework.beans.factory.annotation.Autowired;

import DAO_JPA.IDAOPari;
import data.PariId;

public class AppConsole
{
	@Autowired
	private IDAOPari IDAOPari;
	
	public void run(String[] args) {
		System.out.println(IDAOPari.findByUtilisateurAndMatch(new PariId(1,1)));
		
		
	}
}