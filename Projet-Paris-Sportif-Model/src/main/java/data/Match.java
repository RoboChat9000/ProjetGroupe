package data;


import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;;

@Entity
@Table(name="matches")
public class Match implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MAT_ID")
	protected int id;
	
	@ManyToOne
	@JoinColumn(name = "mat_equipe_dom_id")
	protected Equipe equipeDom;
	
	@ManyToOne
	@JoinColumn(name = "mat_equipe_ext_id")
	protected Equipe equipeExt;
	
	@ManyToOne
	@JoinColumn(name = "MAT_stade_ID")
	protected Stade stade;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="MAT_PHASE")
	protected Phase phase;
	
	@Column(name="MAT_DATEHEURE", nullable=true, columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.DATE)
	protected Date date;
	
	@Column(name="MAT_RESULTAT_DOM", columnDefinition="INT DEFAULT 0")
	@NotEmpty
	protected int resultatDom;
	
	@Column(name="MAT_RESULTAT_EXT", columnDefinition="INT DEFAULT 0")
	@NotEmpty
	protected int resultatExt;
	
	@Column(name="MAT_TERMINE", columnDefinition="BOOLEAN DEFAULT 0")
	protected boolean termine;
	
	@OneToOne (mappedBy = "matchCote", cascade = CascadeType.ALL)
	protected Cote cote;

//	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	
	public Match(Equipe equipeDom, Equipe equipeExt, Stade stade, Phase phase, int resultatExt, int resultatDom, boolean termine, Cote cote)
	{
		this.equipeDom=equipeDom;
		this.equipeExt=equipeExt;
		this.stade=stade;
		this.phase=phase;
		this.resultatExt=resultatExt;
		this.resultatDom=resultatDom;
		this.termine=termine;
		this.cote=cote;		
	}
	
	public Match(Equipe equipeDom, Equipe equipeExt, Stade stade, Phase phase, int resultatExt, int resultatDom, boolean termine)
	{
		this.equipeDom=equipeDom;
		this.equipeExt=equipeExt;
		this.stade=stade;
		this.phase=phase;
		this.resultatExt=resultatExt;
		this.resultatDom=resultatDom;
		this.termine=termine;
	}
	
	
	public Match() {
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public Equipe getEquipeDom() {
		return equipeDom;
	}



	public void setEquipeDom(Equipe equipeDom) {
		this.equipeDom = equipeDom;
	}



	public Equipe getEquipeExt() {
		return equipeExt;
	}



	public void setEquipeExt(Equipe equipeExt) {
		this.equipeExt = equipeExt;
	}



	public Stade getStade() {
		return stade;
	}



	public void setStade(Stade stade) {
		this.stade = stade;
	}



	public Phase getPhase() {
		return phase;
	}



	public void setPhase(Phase phase) {
		this.phase = phase;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
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



	public boolean isTermine() {
		return termine;
	}



	public void setTermine(boolean termine) {
		this.termine = termine;
	}



	public Cote getCote() {
		return cote;
	}



	public void setCote(Cote cote) {
		this.cote = cote;
	}



	public void ajouterCote(Cote cote){
		
	}
	
	public String toString() {
		
		String s = "";
		s =  "Match numéro : " + this.id + "équipes : " + this.equipeDom + " et " + this.equipeExt + "\n";
		return  s;
	}

}
