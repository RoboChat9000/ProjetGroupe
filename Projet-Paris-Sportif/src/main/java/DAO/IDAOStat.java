package DAO;

import java.util.List;
import data.Stat;

public interface IDAOStat extends IDAO<Stat> {
public Stat findById(int id);
public List<Stat> findAll();
public Stat save(Stat entity);
public boolean delete(Stat entity);
}