package data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="stade")
public class Stade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="STA_ID")
	private int id;
	
	@Column(name="STA_NOM", columnDefinition="VARCHAR(50) NOT NULL DEFAULT 'INCONNU'")
	@NotEmpty
	@NotNull
	@Size(max=50)
	private String nom;
	
	@Column(name="STA_VILLE", columnDefinition="VARCHAR(50) NOT NULL DEFAULT 'INCONNU'")
	@NotEmpty
	@NotNull
	@Size(max=50)
	private String ville;
	
	@Column(name="STA_LAT", columnDefinition="DECIMAL(10,6)")
	@NotNull
	private double lat;
	
	@Column(name="STA_LNG", columnDefinition="DECIMAL(10,6)")
	@NotNull
	private double lng;
	
	
	public Stade() {
		
	}
	
	public Stade(String nom, String ville, double lat, double lng) {
	
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
