package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Stade;

public interface IDAOStade extends JpaRepository<Stade, Integer> {

}
