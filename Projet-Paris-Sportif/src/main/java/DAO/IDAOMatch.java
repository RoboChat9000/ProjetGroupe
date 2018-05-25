package DAO;

import java.util.List;

import data.Match;

public interface IDAOMatch extends IDAO<Match, Integer> {
public Match findById(Integer id);
public List<Match> findAll();
public Match save(Match entity);
public boolean delete(Match entity);
}