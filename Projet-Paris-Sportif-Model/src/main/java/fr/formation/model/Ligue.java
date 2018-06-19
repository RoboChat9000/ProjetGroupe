package fr.formation.model;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.model.Views.CommonView;
import fr.formation.model.Views.LigueView;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="ligue")

public class Ligue {
	
	@JsonView(CommonView.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LIG_ID")
	private int id;
	
	@JsonView(CommonView.class)
	@Column(name="LIG_NOM", columnDefinition="VARCHAR(50)")
	@NotEmpty
	@Size(max=50)
	private String nom;
	
	@JsonView(LigueView.class)
	@ManyToMany(mappedBy="listLigue", fetch = FetchType.EAGER)
	private List<Utilisateur> list_utilisateur;
	
	
	public Ligue()
	{}
	
	
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
		return list_utilisateur;
	}

	public void setListUtilisateur(List<Utilisateur> listUtilisateur) {
		this.list_utilisateur = listUtilisateur;
	}
	
	public String toString() {
		String S = nom + " (ID=" + id + ")";
		return S;
	}
	
}
