package DAO;

import java.util.List;

import data.Utilisateur;

public interface IDAOUtilisateur<Utilisateur> extends IDAO<Utilisateur>{
	public Utilisateur findById(int id);
	public List<Utilisateur> findAll();
	public Utilisateur save(Utilisateur entity);
	public boolean delete(Utilisateur entity);
	public Utilisateur findByPseudo (String pseudo);
	public boolean verifPseudo (String pseudo);
	public void rejoinLigue(int idUtil, int idLig);

}
