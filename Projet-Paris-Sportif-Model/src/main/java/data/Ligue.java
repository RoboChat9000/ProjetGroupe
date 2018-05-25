package data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="ligue")

public class Ligue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LIG_ID")
	private int id;
	
	@Column(name="LIG_NOM", columnDefinition="VARCHAR(50)")
	@NotEmpty
	@Size(max=50)
	private String nom;
	
	@ManyToMany(mappedBy="listLigue")
	private List<Utilisateur> listUtilisateur;
	
	public Ligue(int id, String nom) {
		this.id = id;
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

	public List<Utilisateur> getListUtilisateur() {
		return listUtilisateur;
	}

	public void setListUtilisateur(List<Utilisateur> listUtilisateur) {
		this.listUtilisateur = listUtilisateur;
	}
	
	public String toString() {
		String S = nom + " (ID=" + id + ")";
		return S;
	}
	
}
