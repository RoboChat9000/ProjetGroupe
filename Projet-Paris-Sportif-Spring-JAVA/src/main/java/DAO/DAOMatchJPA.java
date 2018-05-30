package DAO;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import data.Match;

public class DAOMatchJPA implements IDAOMatch{

	private EntityManager em;
	
	public DAOMatchJPA() {
		this.em = HibernateUtils.getEntityManager();
	}
	
	public Match findById(Integer id) {
		return em.find(Match.class, id);
	}

	public List<Match> findAll() {
		return  this.em.createQuery("from Match m", Match.class)
				.getResultList();
	}

	public Match save(Match entity) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		entity = em.merge(entity);
		tx.commit();
		return entity;
	}

	public boolean delete(Match entity) {
EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			this.em.remove(this.em.merge(entity));
			tx.commit();
			return true;
		}
		catch (Exception ex) {
			tx.rollback();
			return false;
		}
	}

	
	
}
