package data;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Equipe")
public class Equipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EQU_ID")
	private int id;
	
	
	private int idPoule;
	private String nom;
	
	
	@OneToMany(mappedBy="matchs")
	private List<Match> matchs;
	
	public Equipe(int id, int idPoule, String nom) {
		this.id = id;
		this.idPoule = idPoule;
		this.nom = nom;
	}

	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getIdPoule() {
		return idPoule;
	}



	public void setIdPoule(int idPoule) {
		this.idPoule = idPoule;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String toString() {
		return this.nom;
	}
	
}
