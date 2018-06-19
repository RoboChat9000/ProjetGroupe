package DAO_JAVA;

import java.util.List;

import DAO.IDAO;
import fr.formation.model.Match;

public interface IDAOMatch extends IDAO<Match, Integer> {
public Match findById(Integer id);
public List<Match> findAll();
public Match save(Match entity);
public boolean delete(Match entity);
}