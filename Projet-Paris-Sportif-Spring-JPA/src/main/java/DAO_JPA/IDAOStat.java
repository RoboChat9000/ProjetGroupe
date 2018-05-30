package DAO_JPA;



import org.springframework.data.jpa.repository.JpaRepository;

import data.Stat;
import data.Utilisateur;


public interface IDAOStat extends JpaRepository<Stat, Utilisateur> {

}