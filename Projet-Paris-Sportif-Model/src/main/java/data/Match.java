package data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;;

@Entity
@Table(name="Match")
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MAT_ID")
	protected int id;
	
	@ManyToOne()
	@JoinColumn(name = "EQU_ID")
	protected Equipe equipeDom;
	
	@ManyToOne()
	@JoinColumn(name = "EQU_ID")
	protected Equipe equipeExt;
	
	@ManyToOne()
	@JoinColumn(name = "MAT_ID")
	protected Stade stade;
	
	@ManyToOne()
	@JoinColumn(name = "PHA_ID")
	protected Phase phase;
	
	@Column(name="MAT_DATE", nullable=false, columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.DATE)
	@NotNull
	protected String date;
	
	@Column(name="MAT_RESULTAT_DOM", columnDefinition="INT NOT NULL")
	@NotNull
	@NotEmpty
	protected int resultatDom;
	
	@Column(name="MAT_RESULTAT_EXT", columnDefinition="INT NOT NULL")
	@NotNull
	@NotEmpty
	protected int resultatExt;
	
	@Column(name="MAT_TERMINE", columnDefinition="BOOL DEFAULT 0")
	@NotNull
	@NotEmpty
	protected boolean termine;
	
	@OneToOne()
	@JoinColumn(name = "COT_ID")
	protected Cote cote;

	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
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



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
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
		s =  "Match numéro : " + this.id;
		return  s;
	}

}
