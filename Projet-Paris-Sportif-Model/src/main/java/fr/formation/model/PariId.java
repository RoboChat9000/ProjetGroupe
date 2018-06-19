package fr.formation.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

public class PariId implements Serializable{

	private int utilisateurId;
	private int matchId;
	
//	private Utilisateur utilisateur;
//
//	private Match match;
	
	public PariId(int idUtilisateur, int idMatch) {
		this.utilisateurId = idUtilisateur;
		this.matchId = idMatch;
		
//		this.utilisateur = new Utilisateur();
//		utilisateur.setId(idUtilisateur);
//		this.match = new Match();
//		match.setId(idMatch);
		
	}
//	
	public PariId() {
		
	}
}
