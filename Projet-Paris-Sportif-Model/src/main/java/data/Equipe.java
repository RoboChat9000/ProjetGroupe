package data;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="equipe")
public class Equipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EQU_ID")
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name = "equ_poule_ID")
	private Poule poule;
	
	@Column(name="EQU_NOM", columnDefinition="VARCHAR(50) NOT NULL DEFAULT 'INCONNU'")
	@NotEmpty
	@NotNull
	@Size(max=50)
	private String nom;
	
	
	@OneToMany(mappedBy="equipeDom")
	private List<Match> matchsDom;
	
	@OneToMany(mappedBy="equipeExt")
	private List<Match> matchsExt;
	
	public Equipe() {
	}

	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Poule getPoule() {
		return poule;
	}



	public void setPoule(Poule poule) {
		this.poule = poule;
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
