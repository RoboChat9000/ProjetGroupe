package data;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

public class Pari {

	
	@NotEmpty
	@ManyToOne
	@JoinColumn(name="par_utilisateur_id")
	private Utilisateur utilisateur;
	//faudra potentiellement rajouter une liste de paris pour la classe match
	@NotEmpty
	@ManyToOne
	@JoinColumn(name="par_match_id")
	private Match match;
	@Column(name="par_result_dom", columnDefinition="INT NOT NULL")
	@NotEmpty
	@Min(0)
	private int resultatDom;
	@Column(name="par_result_ext", columnDefinition="INT NOT NULL")
	@NotEmpty
	@Min(0)
	private int resultatExt;
	@NotEmpty
	@OneToOne
	@JoinColumn(name="par_vainqueur")
	private Equipe vainqueur;
	@Column(name="par_DateHeure", columnDefinition="DATETIME")
	@NotEmpty
	private String date;
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public int getResultatDom() {
		return resultatDom;
	}

	public void setResultatDom(int resultatDom) {
		this.resultatDom = resultatDom;
	}

	public int getResultatExt() {
		return resultatExt;
	}

	public void setResultatExt(int resultatExt) {
		this.resultatExt = resultatExt;
	}

	public Equipe getVainqueur() {
		return vainqueur;
	}

	public void setVainqueur(Equipe vainqueur) {
		this.vainqueur = vainqueur;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Pari(Utilisateur utilisateur, Match match, int resultatDom, int resultatExt, Equipe vainqueur, String date) {
		this.utilisateur = utilisateur;
		this.match = match;
		this.resultatDom = resultatDom;
		this.resultatExt = resultatExt;
		this.vainqueur = vainqueur;
		this.date = date;
	}

	public void parier()
	{
		System.out.println("not implemented yet");
	}
	
}
