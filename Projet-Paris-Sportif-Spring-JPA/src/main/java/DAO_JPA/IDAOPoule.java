package DAO_JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Poule;

public interface IDAOPoule extends JpaRepository<Poule, Integer>{

}
