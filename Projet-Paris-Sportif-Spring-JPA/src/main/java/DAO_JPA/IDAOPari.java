package DAO_JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import data.Pari;
import data.PariId;

public interface IDAOPari extends JpaRepository<Pari, PariId>{

}
