package Principal;

import java.sql.SQLException;
import java.text.ParseException;

import DAO.*;
import data.*;

public class DataGenerator {
	public static void main(String[] args) throws SQLException, ParseException { 
	DAOCoteJPA DAOCot = new DAOCoteJPA();
	DAOEquipeJPA DAOEqu = new DAOEquipeJPA();
	DAOMatchJPA DAOMat = new DAOMatchJPA();
	DAOPariJPA DAOPari = new DAOPariJPA();
	DAOStadeJPA DAOStade = new DAOStadeJPA();
	DAOPouleJPA DAOPoule = new DAOPouleJPA();
	DAOStatJPA DAOStat = new DAOStatJPA();
	DAOUtilisateur DAOUtil = new DAOUtilisateur();

	
	Stade S1 = new Stade("leStade", "laVille", 0.5, 1.5);
	DAOStade.save(S1);
	System.out.println(DAOStade.findById(1));
	
	Poule p1 = new Poule("laPoulette");
	DAOPoule.save(p1);
	System.out.println(DAOPoule.findById(1));
	Equipe E1 = new Equipe(p1, "prout");
	DAOEqu.save(E1);
	System.out.println(DAOEqu.findById(1));
	Equipe E2 = new Equipe(p1, "Wildcats");
	DAOEqu.save(E2);
	
	Match m1 = new Match(E1, E2, S1, Phase.Poule, 1, 2, true);

	Cote c1 = new Cote(m1, 1, 2, 3);

	
	m1 = DAOMat.save(m1);
//	DAOCot.save(c1);

	
	System.out.println(DAOMat.findById(1));
	System.out.println(DAOCot.findById(1));

	
	Utilisateur U1 = new Utilisateur("util1", "mail", "mdp");
	U1 = DAOUtil.save(U1);
	Pari Par1 = new Pari(U1, m1, 1, 2, E1);
	Par1 = DAOPari.save(Par1);
	System.out.println(DAOPari.findById(new PariId(1,5)));
	
	HibernateUtils.close();
	
}
}
