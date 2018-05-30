package DAO_JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import data.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IDAOUtilisateur extends JpaRepository<Utilisateur, Integer>
{

	public Utilisateur findById(int id);
	
	
}
