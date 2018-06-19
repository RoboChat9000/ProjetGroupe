package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Match;

public interface IDAOMatch extends JpaRepository<Match, Integer>{
	
	public Match findById(int id);

}
