package fr.formation;

import org.springframework.beans.factory.annotation.Autowired;

import DAO.*;

public class AppConsole
{
	@Autowired
	private IDAOUtilisateur IDAOUti;
	
	public void run(String[] args) {
System.out.println(IDAOUti.findById(1));
		
		
}
}