package DAO_JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import data.Stat;
import data.Match;

public interface IDAOCote extends JpaRepository<Stat, Match>{

}
