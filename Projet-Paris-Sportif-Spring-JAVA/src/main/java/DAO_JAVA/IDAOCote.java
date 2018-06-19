package DAO_JAVA;

import DAO_JAVA.IDAO;
import fr.formation.model.Cote;
import fr.formation.model.Match;


public interface IDAOCote extends IDAO<Cote, Integer> {
	public Cote findById(int id);
}
