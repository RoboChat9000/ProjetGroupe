package DAO;

import java.util.List;

import data.Pari;

public interface IDAOPari extends IDAO<Pari> {
public Pari findById(int id);
public List<Pari> findAll();
public Pari save(Pari entity);
public boolean delete(Pari entity);
}