package DAO_JPA;



import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Stat;
import fr.formation.model.Utilisateur;


public interface IDAOStat extends JpaRepository<Stat, Utilisateur> {

}