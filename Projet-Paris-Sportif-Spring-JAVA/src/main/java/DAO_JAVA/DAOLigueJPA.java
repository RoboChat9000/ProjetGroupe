package DAO_JAVA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import DAO.IDAOLigue;
import DAO_JAVA.HibernateUtils;
import fr.formation.model.Ligue;


public class DAOLigueJPA implements IDAOLigue {

	
		private EntityManager em;
		
		
		public DAOLigueJPA() {
			this.em = HibernateUtils.getEntityManager();
		}
		
		
		
		public Ligue findById(Integer id) {
			return this.em.find(Ligue.class, id);
		}
		
		
		
		public Ligue save(Ligue entity) {
			EntityTransaction tx = this.em.getTransaction();
			
			tx.begin();
			this.em.persist(entity);
			tx.commit();
			
			return entity;
		}

		public boolean delete(Ligue entity) {
			EntityTransaction tx = this.em.getTransaction();
			
			
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
		

		public List<Ligue> findAll() {
			return this.em
					.createQuery("select c from Ligue c", Ligue.class)
					.setHint("org.hibernate.cacheable", true)
					.getResultList();
		}
	
	
}
