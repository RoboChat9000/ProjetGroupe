package fr.formation.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import DAO_JPA.IDAOLigue;
import DAO_JPA.IDAOMatch;
import DAO_JPA.IDAOUtilisateur;
import fr.formation.AppConfig;
import fr.formation.model.Ligue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ AppConfig.class })
public class IDAOUtilisateurTest {

	@Autowired
	ApplicationContext context;
		
	@Autowired
	IDAOUtilisateur IDAOUti;
	
	@Test
	public void verifPseudoTest()
	{
		boolean resultat = IDAOUti.VerifPseudo("bla");
		System.out.println("vérification du pseudo 'bla'...");
		if (resultat == true)
		{
			System.out.println("le pseudo est déja pris");
		}
		else
		{
			System.out.println("le pseudo est disponible");
		}
		
		boolean resultat2 = IDAOUti.VerifPseudo("blaaabla");
		System.out.println("vérification du pseudo 'blaaabla'...");
		if (resultat2 == true)
		{
			System.out.println("le pseudo est déja pris");
		}
		else
		{
			System.out.println("le pseudo est disponible");
		}
	}
	
	
	@Autowired
	IDAOLigue IDAOLig;
	@Autowired
	EntityManager em;
	
	@Test
	@Rollback(true)
	@Transactional
//	@Commit
	public void rejoinLigueTest()
	{
		Ligue L1 = IDAOLig.findById(1).get();
		int size = IDAOLig.findById(1).get().getListUtilisateur().size();
		this.em.clear();
		int id = IDAOLig.findByNom("Ligue des Champignons").getId();
		IDAOUti.rejoinLigue(1, id);
		assertEquals(size+1, IDAOLig.findByNom("Ligue des Champignons").getListUtilisateur().size());

	}
	
}
