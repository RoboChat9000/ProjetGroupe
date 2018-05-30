package DAO_JPA;



import org.springframework.data.jpa.repository.JpaRepository;

import data.Stat;


public interface IDAOStat extends JpaRepository<Stat, Integer> {

}