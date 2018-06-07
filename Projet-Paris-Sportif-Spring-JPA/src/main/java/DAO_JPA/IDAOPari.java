package DAO_JPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import data.Match;
import data.Pari;
import data.PariId;
import data.Utilisateur;

public interface IDAOPari extends JpaRepository<Pari, PariId>{

	public List<Pari> findAll();
	public Pari findByUtilisateurAndMatch(Utilisateur u, Match m);

	@Query("SELECT p FROM Pari p left join p.utilisateur.listLigue l WHERE l.id = :idLigue")
	public List<Pari> findByLigue(@Param("idLigue") int idLigue);
}
