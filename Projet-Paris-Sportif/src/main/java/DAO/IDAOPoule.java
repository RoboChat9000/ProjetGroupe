package DAO;

import java.util.List;

import data.Poule;

public interface IDAOPoule extends IDAO<Poule, Integer> {
public Poule findById(Integer id);
public List<Poule> findAll();
public Poule save(Poule entity);
public boolean delete(Poule entity);
}