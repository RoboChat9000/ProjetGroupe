package DAO_JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import data.Match;

public interface IDAOMatch extends JpaRepository<Match, Integer>{
	
	public Match findById(int id);

}
