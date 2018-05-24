package data;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="poule")
public class Poule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="POU_ID")
	private int id;
	
	@Column(name="POU_NOM", columnDefinition="VARCHAR(50) NOT NULL DEFAULT 'INCONNU'")
	@NotEmpty
	@NotNull
	@Size(max=50)
	private String nom;

	@OneToMany (mappedBy="poule")
	List<Equipe> listeEquipes;
	
	
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
	
	public void classement()
	{
		//algo pour calculer le classement des �quipes au sein de la poule
	}

	
}
