package DAO_JPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import data.Match;
import data.Pari;
import data.PariId;
import data.Utilisateur;

public interface IDAOPari extends JpaRepository<Pari, PariId>{

	public List<Pari> findAll();
	public Pari findByUtilisateurAndMatch(Utilisateur u, Match m);

}
