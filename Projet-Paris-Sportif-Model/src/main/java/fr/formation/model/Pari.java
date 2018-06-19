package fr.formation.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;
@Entity
@IdClass(PariId.class)
public class Pari {
	@Id
	@Column(name="par_utilisateur_id")
	private int utilisateurId;
	@Id
	@Column(name="par_match_id")
	private int matchId;
	
	@MapsId
	@NotNull
	@ManyToOne
	@JoinColumn(name="par_utilisateur_id")
	private Utilisateur utilisateur;
	
	
	@MapsId
	@NotNull
	@ManyToOne
	@JoinColumn(name="par_match_id")
	private Match match;
	
	@Column(name="par_result_dom", columnDefinition="INT NOT NULL")
	@NotNull(message="resultat dom vide")
	@Min(0)
	private int resultatDom;
	
	@Column(name="par_result_ext", columnDefinition="INT NOT NULL")
	@NotNull(message="resultat ext vide")
	@Min(0)
	private int resultatExt;
	
	
	@OneToOne
	@JoinColumn(name="par_vainqueur")
	private Equipe vainqueur;
	
	@Column(name="par_DateHeure", columnDefinition="DATETIME")
	@Temporal(TemporalType.DATE)
	private Date date;
	
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Pari(Utilisateur utilisateur, Match match, int resultatDom, int resultatExt, Equipe vainqueur) {
		this.utilisateur = utilisateur;
		this.match = match;
		this.resultatDom = resultatDom;
		this.resultatExt = resultatExt;
		this.vainqueur = vainqueur;
	
	}

	public void parier()
	{
		System.out.println("not implemented yet");
	}
	
	public Pari()
	{
		
	}
	
	public String toString() {
		return "Pari : " + this.match.toString();
	}
}
