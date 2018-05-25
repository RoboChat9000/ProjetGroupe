package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import data.Ligue;
import data.Utilisateur;
import DAO.HibernateUtils;

public class DAOUtilisateur {
	
	private EntityManager em;
	public DAOUtilisateur()
	{
		this.em = HibernateUtils.getEntityManager();

	}
	public Utilisateur findById(int id);
	
	
	
	
	
	public List<Utilisateur> findAll();
	
	public boolean save(Utilisateur U1) {
		try {
	
			this.connexionBDD();
//			java.sql.Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_paris", "root", "");
			String query = "INSERT INTO utilisateur (uti_ID, uti_pseudo, uti_mail, uti_mdp, uti_nom, uti_prenom, uti_DateNaiss) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement myStatement = connexion.prepareStatement(query);

			
//		PreparedStatement myStatement =
//				myConnection.prepareStatement("INSERT INTO utilisateur (uti_ID, uti_pseudo, uti_mail, uti_mdp, uti_nom, uti_prenom, uti_DateNaiss) VALUES (?, ?, ?, ?, ?, ?, ?)");
				myStatement.setInt(1, U1.getId());
				myStatement.setString(2, U1.getPseudo());
				myStatement.setString(3, U1.getMail());
				myStatement.setString(4, U1.getMdp());
				myStatement.setString(5, U1.getNom());
				myStatement.setString(6, U1.getPrenom());
				
				//convertir la date (java.util.date) en String
				Format formatter = new SimpleDateFormat("yyyy-MM-dd");
				myStatement.setString(7, formatter.format(U1.getDateNaissance()));
				
				myStatement.execute();
						}
		catch (Exception e)
		{
			System.out.println("erreur, dieu seul sait pourquoi");
			e.printStackTrace();
		}
		
		return true;		

	
}
	public Utilisateur select(String pseudo) throws SQLException, ParseException
	{
		this.connexionBDD();
		String query = "SELECT * FROM utilisateur WHERE uti_pseudo = '" + pseudo + "'";
//		try
//		{
		Statement myStatement = connexion.createStatement();
		ResultSet myResult = myStatement.executeQuery(query);
		Utilisateur U = new Utilisateur();
		while(myResult.next()) {
		int id = myResult.getInt("uti_ID");
//		String pseudo = myResult.getString("uti_pseudo");
		String mail = myResult.getString("uti_mail");
		String mdp = myResult.getString("uti_mdp");
		String nom = myResult.getString("uti_nom");
		String prenom = myResult.getString("uti_prenom");
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateNaissance = formatter.parse(myResult.getString("uti_DateNaiss"));
		U = new Utilisateur(pseudo, mail, mdp, nom, prenom, dateNaissance);
		U.setId(id);
		}

//		}
//		catch(Exception e)
//		{
//			System.out.println("erreur au niveau de la requete sql");
//			e.printStackTrace();
//
//		}
		return U;
	}
	public boolean verifPseudo (String pseudo) throws SQLException
	{
		this.connexionBDD();
		String query = "SELECT uti_pseudo FROM utilisateur WHERE uti_pseudo = '" + pseudo + "'";

		Statement myStatement = connexion.createStatement();
		ResultSet myResult = myStatement.executeQuery(query);

		if (myResult.next())
		{
			return false;
		}
		else
		{
			return true;
		}

	}
	

public void rejoinLigue(int idUtil, int idLig) throws SQLException
{
	
	this.connexionBDD();
	String query = "INSERT INTO utilisateur_ligue (ul_utilisateur_id, ul_ligue_id) VALUES ((SELECT uti_id FROM utilisateur WHERE uti_id = ?), (SELECT lig_id FROM ligue WHERE lig_id = ?))" ;
	PreparedStatement myStatement = connexion.prepareStatement(query);
	myStatement.setInt(1, idUtil);
	myStatement.setInt(2, idLig);
	myStatement.execute();
}
}
