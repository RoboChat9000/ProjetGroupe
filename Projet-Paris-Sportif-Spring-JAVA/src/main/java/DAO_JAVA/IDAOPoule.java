package DAO_JAVA;

import java.util.List;

import DAO.IDAO;
import fr.formation.model.Poule;

public interface IDAOPoule extends IDAO<Poule, Integer> {
public Poule findById(Integer id);
public List<Poule> findAll();
public Poule save(Poule entity);
public boolean delete(Poule entity);
}