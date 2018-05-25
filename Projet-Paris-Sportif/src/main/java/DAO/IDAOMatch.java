package DAO;

import java.util.List;

import data.Match;

public interface IDAOMatch extends IDAO<Match> {
public Match findById(int id);
public List<Match> findAll();
public Match save(Match entity);
public boolean delete(Match entity);
}