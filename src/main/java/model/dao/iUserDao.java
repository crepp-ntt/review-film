package model.dao;

import model.entity.User;

import java.sql.ResultSet;
import java.util.List;

public interface iUserDao extends iDAO<User> {

    /**
     * Find all user in database
     * @return List<User>: all users in database
     */
    @Override
    List<User> findAll();

    List<User> findTopUser();


    /**
     * Find user by username
     * @param username: String (username of user)
     * @return User: user entity
     */
    @Override
    User findOne(Object username);

    @Override
    int delete(User T);

    /**
     * Insert user into database
     * @param user: user entity
     * @return 1: success, 0: false
     */
    @Override
    int insert(User user);

    /**
     * Update user in database
     * @param user: user entity
     * @return 1: success, 0: false
     */
    @Override
    int update(User user);

    /**
     * Create user entity from ResultSet
     * @param rs: ResultSet form query database
     * @return User: user entity
     */
    @Override
    User create(ResultSet rs);

    /**
     * Change password of user in database
     * @param username: username of user
     * @param password: new password
     * @return 1: success, 0: false
     */
    int changePassword(String username, String password);
}
