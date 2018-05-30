package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import DAO.HibernateUtils;
import data.Cote;

public class DAOCoteJPA implements IDAOCote {

	
		private EntityManager em;
		
		
		public DAOCoteJPA() {
			this.em = HibernateUtils.getEntityManager();
		}
		
		
		
		public Cote findById(Integer id) {
			return this.em.find(Cote.class, id);
		}
		
		
		
		public Cote save(Cote entity) {
			EntityTransaction tx = this.em.getTransaction();
			
			tx.begin();
			this.em.persist(entity);
			tx.commit();
			
			return entity;
		}

		public boolean delete(Cote entity) {
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
		

		public List<Cote> findAll() {
			return this.em
					.createQuery("select c from Cote c", Cote.class)
					.setHint("org.hibernate.cacheable", true)
					.getResultList();
		}
	
	
}
