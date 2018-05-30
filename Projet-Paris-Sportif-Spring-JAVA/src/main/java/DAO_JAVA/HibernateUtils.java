package DAO_JAVA;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtils {

	private static EntityManagerFactory emf;
	private static List<EntityManager> entityManagers = new ArrayList<EntityManager>();
	
	public static void open()
	{
		if (emf == null)
		emf = Persistence.createEntityManagerFactory("Persist");
	}
	
	public static void close()
	{
		for (EntityManager em : entityManagers) {
			emf.close();
		}
	}
	public static EntityManager getEntityManager()
	{
		if (emf == null)
		{
			open();
		}
		EntityManager em = emf.createEntityManager();
		entityManagers.add(em);
		return em;
	}
}
