package DAO;

import java.util.List;

import data.Poule;

public interface IDAOPoule extends IDAO<Poule> {
public Poule findById(int id);
public List<Poule> findAll();
public Poule save(Poule entity);
public boolean delete(Poule entity);
}