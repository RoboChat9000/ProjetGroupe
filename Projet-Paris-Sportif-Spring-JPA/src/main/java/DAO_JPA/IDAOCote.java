package DAO_JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



import data.Cote;
import data.Match;

public interface IDAOCote extends JpaRepository<Cote,Integer>{
	
//	@Query("select m from Match m where m.id = :id")
//	public Cote findByMatch(@Param("id") Match match); 
	
///*	@Query("select c from Match m where m.cote = :id")
//	public Cote findByMatchCote(@Param("matchCote") Match match); */
}
	



