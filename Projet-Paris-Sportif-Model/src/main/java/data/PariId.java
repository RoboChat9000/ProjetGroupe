package data;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

public class PariId implements Serializable{

	private Utilisateur utilisateur;

	private Match match;
}
