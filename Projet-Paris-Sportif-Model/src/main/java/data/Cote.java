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
	
}
