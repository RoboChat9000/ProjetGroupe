package data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cote")
public class Cote implements Serializable{

	@Id
	private Integer id;
	
	@MapsId
	@OneToOne
	@JoinColumn(name="cot_match_id")
	private Match matchCote;
	
	@Column(name="COT_DOM")
	private int dom;
	
	@Column(name="COT_NUL")
	private int nul;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Match getMatchCote() {
		return matchCote;
	}
	public void setMatchCote(Match matchCote) {
		this.matchCote = matchCote;
	}
	public int getDom() {
		return dom;
	}
	public void setDom(int dom) {
		this.dom = dom;
	}
	public int getNul() {
		return nul;
	}
	public void setNul(int nul) {
		this.nul = nul;
	}
	public int getExt() {
		return ext;
	}
	public void setExt(int ext) {
		this.ext = ext;
	}
	@Column(name="COT_EXT")
	private int ext;
	
/*	private int vainqueurDom;
	private int vainqueurExt;*/
	
	public Cote()
	{
		
	}
	public Cote(Match match, int coteDom, int coteNul, int coteExt) {
		this.matchCote = match;
		this.dom = coteDom;
		this.nul = coteNul;
		this.ext = coteExt;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Match getMatchCote() {
		return matchCote;
	}
	public void setMatchCote(Match matchCote) {
		this.matchCote = matchCote;
	}
	public int getDom() {
		return dom;
	}
	public void setDom(int dom) {
		this.dom = dom;
	}
	public int getNul() {
		return nul;
	}
	public void setNul(int nul) {
		this.nul = nul;
	}
	public int getExt() {
		return ext;
	}
	public void setExt(int ext) {
		this.ext = ext;
	}
	
	
	
	
	
	
}
