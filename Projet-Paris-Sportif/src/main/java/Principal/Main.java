package Principal;


import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import data.Equipe;
import data.Match;
import data.Pari;
import data.Phase;
import data.Stade;
import data.Utilisateur;

public class Main {

	public static void main(String[] args) throws SQLException, ParseException {  
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persist");
		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		tx.commit();
		em.close();
		emf.close();
		
}
}