package DAO_JPA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import data.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IDAOUtilisateur extends JpaRepository<Utilisateur, Integer>
{

	public Utilisateur findById(int id);
	public List<Utilisateur> findAll();
	public Utilisateur findByPseudo (String pseudo);
	
	//retourne vrai si le pseudo existe deja
	 @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Utilisateur u WHERE u.pseudo = :pseudo")
	    boolean VerifPseudo(@Param("pseudo") String pseudo);

	 @Transactional
	 @Modifying
	 @Query(nativeQuery=true, value="INSERT INTO `projet_paris_true`.`listutilisateur` (ul_utilisateur_id, ul_ligue_id) VALUES ((SELECT uti_id FROM utilisateur WHERE uti_id = :idUtil), (SELECT lig_id FROM ligue WHERE lig_id = :idLig))")
	 public void rejoinLigue(@Param("idUtil") int idUtil, @Param("idLig") int idLig);

	
		
	
	
	
}
