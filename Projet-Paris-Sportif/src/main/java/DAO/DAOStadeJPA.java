package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import DAO.HibernateUtils;
import fr.formation.model.Stade;

public class DAOStadeJPA implements IDAOStade {

	
		private EntityManager em;
		
		
		public DAOStadeJPA() {
			this.em = HibernateUtils.getEntityManager();
		}
		
		
		
		public Stade findById(Integer id) {
			return this.em.find(Stade.class, id);
		}
		
		
		
		public Stade save(Stade entity) {
			EntityTransaction tx = this.em.getTransaction();
			
			tx.begin();
			this.em.persist(entity);
			tx.commit();
			
			return entity;
		}

		public boolean delete(Stade entity) {
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
		

		public List<Stade> findAll() {
			return this.em
					.createQuery("select s from Stade s", Stade.class)
					.setHint("org.hibernate.cacheable", true)
					.getResultList();
		}
	
	
}
