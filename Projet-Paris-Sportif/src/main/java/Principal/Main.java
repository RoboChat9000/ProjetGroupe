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
import data.*;

public class Main {

	public static void main(String[] args) throws SQLException, ParseException {  
		HibernateUtils.open();
DAOMatchJPA DAOMat = new DAOMatchJPA();
DAOStadeJPA DAOSta = new DAOStadeJPA();
//PariId AI = new PariId(1,1);
System.out.println(DAOMat.findById(1));
System.out.println(DAOSta.findAll());
DAOUtilisateur DAOUtil = new DAOUtilisateur();
System.out.println(DAOUtil.findById(1));
		HibernateUtils.close();
	
}
}