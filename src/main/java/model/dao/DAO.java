package model.dao;

import java.util.List;

public interface DAO<T> {
    public List<T> findAll();
    public T findOne(int id);
    public int delete(T T);
    public int insert(T t);
    public int update(T t);
}
