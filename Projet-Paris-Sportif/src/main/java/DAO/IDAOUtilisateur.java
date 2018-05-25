package DAO;

import java.util.List;

public interface IDAOUtilisateur<Utilisateur> extends IDAO<Utilisateur>{
	public Utilisateur findById(int id);
	public List<Utilisateur> findAll();
	public Utilisateur save(Utilisateur entity);
	public boolean delete(Utilisateur entity);
}
