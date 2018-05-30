package fr.formation.test;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import DAO_JPA.IDAOPari;
import data.PariId;
import fr.formation.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ AppConfig.class })
public class IDAOPariTest {
	
	@Autowired
	ApplicationContext context;
		
	@Autowired
	IDAOPari IDAOPari;

	
	@Test
	public void findAllTest()
	{
		assertNotEquals(0, IDAOPari.findAll().size());
	}
	
	
	@Test
	public void findByIdTest() {
		assertNotEquals(0, IDAOPari.findById(new PariId(1,1)));
	}
	
}
	