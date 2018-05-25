package data;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="statistiques")
public class Stat implements Serializable{
	@Id
	@OneToOne
	@JoinColumn (name="stat_utilisateur_id")
	private Utilisateur utilisateur;
	
	@Column (name="stat_points", columnDefinition="int")
	int points;
	//on va rajouter le reste apres lol
}
