package data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence;

@Entity
@DiscriminatorValue("Match")
public class Match {

	protected int id;
	protected int equipeDom;
	protected int equipeExt;
	protected int stade;
	protected Phase phase;
	protected String date;
	protected int resultatDom;
	protected int resultatExt;
	protected boolean termine;
	protected Cote cote;

	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	public Match(int id, int equipeDom, int equipeExt, int stade, String date, Phase phase) {
		this.id = id;
		this.equipeDom = equipeDom;
		this.equipeExt = equipeExt;
		this.stade = stade;
		this.date = date;
		this.phase = phase;
	}
	
	public Match(int id, int equipeDom, int equipeExt, int stade, String date, Phase phase, int resultatDom, int resultatExt) {
		this.id = id;
		this.equipeDom = equipeDom;
		this.equipeExt = equipeExt;
		this.stade = stade;
		this.date = date;
		this.phase = phase;
		this.resultatDom = resultatDom;
		this.resultatExt = resultatExt;
	}
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getEquipeDom() {
		return equipeDom;
	}



	public void setEquipeDom(int equipeDom) {
		this.equipeDom = equipeDom;
	}



	public int getEquipeExt() {
		return equipeExt;
	}



	public void setEquipeExt(int equipeExt) {
		this.equipeExt = equipeExt;
	}



	public int getStade() {
		return stade;
	}



	public void setStade(int stade) {
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
