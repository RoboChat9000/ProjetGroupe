package data;

import javax.persistence.*;
import javax.persistence.OneToOne;

@Entity
@Table(name="statistiques")
public class Stat {

	@OneToOne
	@JoinColumn (name="stat_utilisateur_id")
	private Utilisateur utilisateur;
	
	@Column (name="stat_points", columnDefinition="int")
	int points;
	//on va rajouter le reste apres lol
}
