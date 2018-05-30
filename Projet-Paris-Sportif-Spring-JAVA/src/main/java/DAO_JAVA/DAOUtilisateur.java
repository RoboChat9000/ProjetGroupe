package DAO_JAVA;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import DAO_JAVA.HibernateUtils;
import data.Ligue;
import data.Utilisateur;

public class DAOUtilisateur {
	
	private EntityManager em;
	
	public DAOUtilisateur()
	{
		this.em = HibernateUtils.getEntityManager();

	}
	public Utilisateur findById(int id) {
		return this.em.find(Utilisateur.class,  id);
	};
	
	public List<Utilisateur> findAll() {
		return this.em.createNativeQuery("select * from Utilisateur", Utilisateur.class).setHint("org.hibernate.cacheable", true).getResultList();
	};
	
	public Utilisateur save(Utilisateur entity) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		entity = this.em.merge(entity);
		tx.commit();
		return entity;
	
}
	public Utilisateur findByPseudo (String pseudo)
	{
		
		Query myQuery = this.em.createQuery("select DISTINCT u from Utilisateur u where u.pseudo like :pseudo", Utilisateur.class);
		myQuery.setParameter("pseudo", "%" + pseudo + "%");
		return (Utilisateur) myQuery.getSingleResult();
		
	}
	
	public boolean verifPseudo (String pseudo) throws SQLException
	{
		Query myQuery = this.em.createQuery("select DISTINCT u from Utilisateur u where u.pseudo like :pseudo", Utilisateur.class);
		myQuery.setParameter("pseudo", "%" + pseudo + "%");
		ResultSet myResult = (ResultSet) myQuery.getSingleResult();

		if (myResult.next())
		{
			return false;
		}
		else
		{
			return true;
		}

	}
	

public void rejoinLigue(int idUtil, int idLig)
{
	Query myQuery = this.em.createQuery("INSERT INTO utilisateur_ligue (ul_utilisateur_id, ul_ligue_id) VALUES ((SELECT uti_id FROM utilisateur WHERE uti_id = :idUtil), (SELECT lig_id FROM ligue WHERE lig_id = :idLig))", Utilisateur.class);
	myQuery.setParameter("idUtil", "%" + idUtil + "%");
	myQuery.setParameter("idLig", "%" + idLig + "%");
	
}
}
