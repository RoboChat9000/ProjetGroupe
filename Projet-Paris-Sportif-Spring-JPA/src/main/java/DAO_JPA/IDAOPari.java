package DAO_JPA;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import data.Pari;
import data.PariId;

public interface IDAOPari extends JpaRepository<Pari, PariId>{

	public List<Pari> findAll();
	public Pari findByUtilisateurAndMatch(PariId id);
}
