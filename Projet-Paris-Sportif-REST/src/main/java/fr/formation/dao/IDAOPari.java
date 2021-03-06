package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.model.Match;
import fr.formation.model.Pari;
import fr.formation.model.PariId;
import fr.formation.model.Utilisateur;

public interface IDAOPari extends JpaRepository<Pari, PariId>{

	public List<Pari> findAll();
	
	public List<Pari> findByUtilisateurId(int id);
	
	public Pari findByUtilisateurAndMatch(Utilisateur u, Match m);

	@Query("SELECT p FROM Pari p left join p.utilisateur.listLigue l WHERE l.id = :idLigue and p.matchId = :idMatch")
	public List<Pari> findByLigue(@Param("idLigue") int idLigue, @Param("idMatch") int idMatch);
}
