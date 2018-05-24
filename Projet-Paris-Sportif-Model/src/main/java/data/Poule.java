package data;


public class Poule {

	private int id;
	private String nom;

	
	public Poule(String nom) {
		this.nom = nom;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
	public String toString() {
		String s = "Poule " + nom + " \n";
		return s;
	}

	
}
