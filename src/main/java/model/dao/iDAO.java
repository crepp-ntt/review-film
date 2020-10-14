package model.dao;

import java.sql.ResultSet;
import java.util.List;

public interface iDAO<T> {
    public List<T> findAll();
    public T findOne(Object input);
    public int delete(T T);
    public int insert(T t);
    public int update(T t);
    public T create(ResultSet rs);
}
