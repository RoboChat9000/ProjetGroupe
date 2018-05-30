package DAO_JAVA;
import java.util.List;

public interface IDAO<T, Id> {
public T findById(Id id);
public List<T> findAll();
public T save(T entity);
public boolean delete(T entity);
}