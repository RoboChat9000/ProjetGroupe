package DAO_JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Equipe;

public interface IDAOEquipe extends JpaRepository<Equipe, Integer>{

}
