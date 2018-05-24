package data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cote")
public class Cote {

	
	@OneToOne
	@Column(name="COT_MATCH")
	private Match match;
	
	@OneToOne
	@Column(name="COT_DOM")
	private int dom;
	
	@OneToOne
	@Column(name="COT_NUL")
	private int nul;
	
	@OneToOne
	@Column(name="COT_EXT")
	private int ext;
	
/*	private int vainqueurDom;
	private int vainqueurExt;*/
	
	public Cote(Match match, int coteDom, int coteNul, int coteExt /*, int coteVainqueurDom, int coteVainqueurExt*/) {
		this.match = match;
		this.dom = dom;
		this.nul = nul;
		this.ext = ext;
/*		this.vainqueurDom = vainqueurDom;
		this.vainqueurExt = vainqueurExt;*/
	}
	
}
