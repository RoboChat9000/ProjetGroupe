package DAO_JAVA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import DAO.IDAOEquipe;
import DAO_JAVA.HibernateUtils;
import fr.formation.model.Equipe;

public class DAOEquipeJPA implements IDAOEquipe {

		
		private EntityManager em;
		
		
		public DAOEquipeJPA() {
			this.em = HibernateUtils.getEntityManager();
		}
		
		
		
		public Equipe findById(Integer id) {
			return this.em.find(Equipe.class, id);
		}
		
		
		
		public Equipe save(Equipe entity) {
			EntityTransaction tx = this.em.getTransaction();
			
			tx.begin();
			this.em.persist(entity);
			tx.commit();
			
			return entity;
		}

		public boolean delete(Equipe entity) {
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
		

		public List<Equipe> findAll() {
			return this.em
					.createQuery("select e from Equipe e", Equipe.class)
					.setHint("org.hibernate.cacheable", true)
					.getResultList();
		}
	
	
}

