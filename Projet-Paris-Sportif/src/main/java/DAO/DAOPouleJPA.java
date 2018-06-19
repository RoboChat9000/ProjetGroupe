package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.formation.model.Poule;

public class DAOPouleJPA implements IDAOPoule{
	
	
private EntityManager em;
	
	public DAOPouleJPA() {
		this.em = HibernateUtils.getEntityManager();
	}

	public Poule findById(Integer id) {
		return em.find(Poule.class, id);
	}

	public List<Poule> findAll() {
		return  this.em.createQuery("from Poule p", Poule.class)
				.getResultList();
	}

	public Poule save(Poule entity) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(entity);
		tx.commit();
		return entity;
	}

	public boolean delete(Poule entity) {
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
