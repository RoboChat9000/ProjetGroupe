package DAO_JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Ligue;

public interface IDAOLigue extends JpaRepository<Ligue, Integer>{

	public Ligue findByNom (String nom);
	
//	public List<Utilisateur> listUtilisateursOfLigue()
}
