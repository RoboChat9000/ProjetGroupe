package fr.formation.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.model.Views.CommonView;

@Entity
@Table(name="statistiques")
public class Stat implements Serializable{
	
	@JsonView(CommonView.class)
	@Id
	private Integer id;
	
	@MapsId
	@OneToOne
	@JoinColumn (name="stat_utilisateur_id")
	private Utilisateur utilisateur;
	
	@JsonView(CommonView.class)
	@Column (name="stat_points", columnDefinition="int")
	int points;
	//on va rajouter le reste apres lol
	
	public Stat()
	{}
}
