package data;

public class Stade {

	private int id;
	private String nom;
	private String ville;
	private double lat, lng;
	
	
	public Stade() {
		
	}
	
	public Stade(int id, String nom, String ville, double lat, double lng) {
		this.id = id;
		this.nom = nom;
		this.ville = ville;
		this.lat = lat;
		this.lng = lng;
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

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}
	
	public String toString() {
		String s;
		s = this.nom; 
		return s;
	}
	
	
}