

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import DAO.DAODataSql;
import data.Equipe;
import data.Match;
import data.Pari;
import data.Phase;
import data.Stade;
import data.Utilisateur;

public class Main {

	public static void main(String[] args) throws SQLException, ParseException {
		
		Utilisateur U = Utilisateur.connectUtil();
		System.out.println(U.getId());
		Utilisateur.rejoinLigue(U);
		
//		Utilisateur.creerUtil();
//		Utilisateur U = Utilisateur.connectUtil();
//		System.out.println(U);
		
		/*
		 * 
		 * //SIMULATION DE PARI AVEC CLASSES PRE-INSTANCIEES
		Utilisateur utilisateur = new Utilisateur("blabla", "bla.bla@bla.com", "blabla");
		Equipe e1 = new Equipe(1, 1, "marseille");
		Equipe e2 = new Equipe(2, 1, "arsenal");
		Stade stade = new Stade(1, "le stade", "la ville", 1.12, 1.12);
		Match match = new Match(1, 1, 2, 1, "2018-06-14", Phase.Poule, 1, 2);


		Scanner sc = new Scanner(System.in);
		System.out.println("Faites votre pari! Saisissez le score de l'equipe domicile : ");
		int resultatDom = sc.nextInt();
		System.out.println("Saisissez le score de l'equipe exterieur : ");
		int resultatExt = sc.nextInt();
		System.out.println("Saisissez le vainqueur (1=> marseille ; 2=>arsenal) : ");
		Equipe vainqueur = new Equipe(3,3,"bla");
		
while(!vainqueur.equals(e1) && !vainqueur.equals(e2))	
{
	int choix = sc.nextInt();
if (choix == 1)
{
	vainqueur = e1;
}
else if (choix == 2)
{
	vainqueur = e2;

}
else
{
	System.out.println("erreur, saisir 1 ou 2");
}
}	
		Pari pari = new Pari(utilisateur, match, resultatDom, resultatExt, vainqueur, "2018-06-14");
		if(pari.getResultatDom() == match.getResultatDom() &&  pari.getResultatExt() == match.getResultatExt())
		{
			System.out.println("vous avez gagné!");
		}
		else
			System.out.println("perdu!");
		
	}
	public static Utilisateur connectUtil() throws SQLException, ParseException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("saisissez votre pseudo");
		String pseudo = sc.next();
		DAODataSql daoUtil = new DAODataSql();
		daoUtil.select(pseudo);
		boolean verifMDP = false;
		while(verifMDP == false)
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("saisissez le mot de passe");
			String leMDP = scan.nextLine();
			if (leMDP.equals(daoUtil.select(pseudo).getMdp()))
			{
				verifMDP = true;
			}
			else
			{
				System.out.println("mot de passe incorrect, veuillez réessayer");
			}
		}
		return daoUtil.select(pseudo);
	}
	
	public static void creerUtil () throws SQLException
    {
		Scanner sc = new Scanner(System.in);
		DAODataSql daoUtil2 = new DAODataSql();
		boolean cont = false;
		String pseudo = null;
		
		while(cont == false)
		{
		System.out.println("Nouvel utilisateur, veuillez saisir votre Pseudo : ");
		pseudo = sc.nextLine();
		cont = daoUtil2.verifPseudo(pseudo);
		if (cont == false)
			System.out.println("ce pseudo est déjà pris, veuillez en saisir un autre");
		}
		
		System.out.println("Veuillez saisir votre mail : ");
		String mail = sc.nextLine();
		boolean mdpConfirm = false;	
		String mdp = "bla";
		while (mdpConfirm == false)
		{
		System.out.println("Veuillez saisir votre mot de passe : ");
		mdp = sc.nextLine();
		System.out.println("Veuillez confirmer votre mot de passe : ");
		if(sc.nextLine().equals(mdp))
		{
			mdpConfirm = true;
		}
		else
		{
			System.out.println("erreur, veuillez resaisir");
		}
		}
		System.out.println("Veuillez saisir votre nom : ");
		String nom = sc.next();
		System.out.println("Veuillez saisir votre prenom : ");
		String prenom = sc.next();
		System.out.println("Veuillez saisir votre date de naissance (en format AAAA-MM-JJ) : ");
	
		//convertir String a date...
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateNaissance = null;
		try
	    {
			Scanner scan = new Scanner(System.in);
		dateNaissance = formatter.parse(scan.nextLine());
	    }
	    catch (Exception e1)
	    {
	    	System.out.println("erreur, veuillez saisir une date de naissance en format mois-jour-année");
	    }
		
		DAODataSql daoUtil = new DAODataSql();
		Utilisateur U1 = new Utilisateur(pseudo, mail, mdp, nom, prenom, dateNaissance);
	
//		Format formatter2 = new SimpleDateFormat("yyyy-MM-dd");
//	    System.out.println(formatter2.format(U1.getDateNaissance()));
	    
		daoUtil.save(U1);
    }
    */
}
}
