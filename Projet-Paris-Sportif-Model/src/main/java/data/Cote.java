package data;

public class Cote {

	private int idMatch;
	private int dom;
	private int nul;
	private int ext;
	private int vainqueurDom;
	private int vainqueurExt;
	
	public Cote(int idMatch, int coteDom, int coteNul, int coteExt, int coteVainqueurDom, int coteVainqueurExt) {
		this.idMatch = idMatch;
		this.dom = dom;
		this.nul = nul;
		this.ext = ext;
		this.vainqueurDom = vainqueurDom;
		this.vainqueurExt = vainqueurExt;
	}
	
}
