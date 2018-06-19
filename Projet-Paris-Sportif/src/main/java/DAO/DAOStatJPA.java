package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.formation.model.Stat;

public class DAOStatJPA implements IDAOStat{
	
	
private EntityManager em;
	
	public DAOStatJPA() {
		this.em = HibernateUtils.getEntityManager();
	}

	public Stat findById(Integer id) {
		return em.find(Stat.class, id);
	}

	public List<Stat> findAll() {
		return  this.em.createQuery("from Stat s", Stat.class)
				.getResultList();
	}

	public Stat save(Stat entity) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(entity);
		tx.commit();
		return entity;
	}

	public boolean delete(Stat entity) {
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
