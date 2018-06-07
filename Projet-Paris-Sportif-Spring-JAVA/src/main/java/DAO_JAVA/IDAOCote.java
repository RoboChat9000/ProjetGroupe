package DAO_JAVA;

import DAO_JAVA.IDAO;
import data.Cote;
import data.Match;


public interface IDAOCote extends IDAO<Cote, Integer> {
	public Cote findById(int id);
}
