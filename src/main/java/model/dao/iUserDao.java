package model.dao;

import model.entity.User;

import java.sql.ResultSet;
import java.util.List;

public interface iUserDao extends iDAO<User> {


    @Override
    List<User> findAll();


    @Override
    User findOne(Object username);

    @Override
    int delete(User T);

    @Override
    int insert(User user);

    @Override
    int update(User user);

    @Override
    User create(ResultSet rs);
}
