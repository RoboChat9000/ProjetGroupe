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

import DAO.*;
import data.Equipe;
import data.Match;
import data.Pari;
import data.Phase;
import data.Stade;
import data.Utilisateur;

public class Main {

	public static void main(String[] args) throws SQLException, ParseException {  
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persist");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		tx.commit();
	
//		Utilisateur U1 = new Utilisateur("Gandoulf le grit", "Gandoulf@TDMM.com", "Mithrandir", "Day", "Léo");
//				
//		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			U1.setDateNaissance(formatter.parse("1990-10-10"));
//			
//		} catch (ParseException e) {
//			System.out.println("erreur au niveau de la création de la date de naissance du client");
//			e.printStackTrace();
//		}
		
//		DAOUtilisateur DAOUtil = new DAOUtilisateur();
////		DAOUtil.save(U1);
//		System.out.println(DAOUtil.findById(1));
//		HibernateUtils.close();
		
}
}