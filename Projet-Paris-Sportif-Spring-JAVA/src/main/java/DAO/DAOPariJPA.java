package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import data.Pari;
import data.PariId;

public class DAOPariJPA implements IDAOPari{
	
	
private EntityManager em;
	
	public DAOPariJPA() {
		this.em = HibernateUtils.getEntityManager();
	}

	public Pari findById(PariId id) {
		return em.find(Pari.class, id);
	}

	public List<Pari> findAll() {
		return  this.em.createQuery("from Pari p", Pari.class)
				.getResultList();
	}

	public Pari save(Pari entity) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		entity = em.merge(entity);
		tx.commit();
		return entity;
	}

	public boolean delete(Pari entity) {
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
