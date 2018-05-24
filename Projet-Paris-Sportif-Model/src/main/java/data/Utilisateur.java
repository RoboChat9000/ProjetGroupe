package data;


import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name="utlisateur")
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="UTI_ID")
	private int id;
	@Column(name="UTI_PSEUDO", columnDefinition="VARCHAR(50)")
	@NotEmpty
	@Size(max=50)
	private String pseudo;
	@Column(name="UTI_MAIL", columnDefinition="VARCHAR(50)")
	@NotEmpty
	@Size(max=50)
	private String mail;
	@Column(name="UTI_MDP", columnDefinition="VARCHAR(50)")
	@NotEmpty
	@Size(max=50)
	private String mdp; 
	@Column(name="UTI_NOM", columnDefinition="VARCHAR(50)")
	@NotEmpty
	@Size(max=50)
	private String nom;
	@Column(name="UTI_PRENOM", columnDefinition="VARCHAR(50)")
	@NotEmpty
	@Size(max=50)
	private String prenom;
	@Column(name="UTI_DATENAISS", columnDefinition="DATE")
	@NotEmpty
	private Date dateNaissance;
	
	@ManyToMany
	@JoinTable(
			name="listUtilisateur", 
			inverseJoinColumns=@JoinColumn(name="ul_ligue_id", referencedColumnName="lig_id"),
		    joinColumns=@JoinColumn(name="ul_utilisateur_id", referencedColumnName="uti_id"))
	private List<Ligue> listLigue = new ArrayList<Ligue>();
	
	@OneToMany(mappedBy="utilisateur")
	private List<Pari> lesParis;
	
	public Utilisateur()
	{
		
	}
	@Override
	public String toString() {
		String S = pseudo +" "+ mail+" " + nom+" " + prenom;
		return S;
	}
	public Utilisateur(String pseudo, String mail, String mdp) {
		
		this.pseudo = pseudo;
		this.mail= mail;
		this.mdp = mdp;
	}
	
	
	public Utilisateur(String pseudo, String mail, String mdp, String nom, String prenom, Date dateNaissance) {
		
		this.pseudo = pseudo;
		this.mail= mail;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Date getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
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
	    	System.out.println("erreur, veuillez saisir une date de naissance en format année-mois-jour");
	    }
		
		DAODataSql daoUtil = new DAODataSql();
		Utilisateur U1 = new Utilisateur(pseudo, mail, mdp, nom, prenom, dateNaissance);
	
//		Format formatter2 = new SimpleDateFormat("yyyy-MM-dd");
//	    System.out.println(formatter2.format(U1.getDateNaissance()));
	    
		daoUtil.save(U1);
    }
	
	public static void rejoinLigue (Utilisateur U) throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("sélectionnez l'ID d'une ligue à rejoindre : ");
		DAODataSql daoUtil3 = new DAODataSql();
		System.out.println(daoUtil3.listLigue());
		int choixLig = sc.nextInt();
		daoUtil3.rejoinLigue(U.getId(), choixLig);
		System.out.println("vous (" + U.getPseudo() + ") avez rejoint la ligue " + daoUtil3.listLigue().get(choixLig-1));
	}
}