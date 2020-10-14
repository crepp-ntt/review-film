package model.dao.impl;

import constant.CONSTANT;
import model.dao.iUserDao;
import model.entity.User;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements iUserDao {
    private static final
    String FIND_ALL = "SELECT * FROM users";

    private static final
    String INSERT = "INSERT INTO users(username, password, name, email) VALUES (?,?,?,?)";

    private static final
    String UPDATE = "UPDATE users SET password=?,name=?,email=?,dob=?,phone=?,avt=? WHERE username=?";

    private static final
    String FIND_ONE = "SELECT * FROM users WHERE username=?";


    /**
     * Method to get all user in database
     * @return List<User>: all users in database
     */
    @Override
    public List<User> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        List<User> users = new ArrayList<User>();
        try{
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_ALL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                users.add(create(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(stmt);
            close(conn);
        }
        return users;
    }

    /**
     * This method find user by username
     * @param username: username of user
     * @return user: user entity
     */
    @Override
    public User findOne(Object username) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_ONE);
            stmt.setString(1, (String)username);

            ResultSet rs =  stmt.executeQuery();
            if(rs.next())
                return create(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }



    @Override
    public int delete(User T) {
        return 0;
    }

    @Override
    public int insert(User users) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            conn = getConnection();
            stmt = conn.prepareStatement(INSERT);
            stmt.setString(1, users.getUsername());
            stmt.setString(2, users.getPassword());
            stmt.setString(3, users.getName());
            stmt.setString(4, users.getEmail());



            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(stmt);
            close(conn);
        }
    }

    @Override
    public int update(User user) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            conn = getConnection();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setString(1, user.getPassword());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getEmail());
            stmt.setDate(4, user.getDob());
            stmt.setString(5, user.getPhone());
            stmt.setString(6, user.getAvt());
            stmt.setString(7,user.getUsername());


            return stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(stmt);
            close(conn);
        }
    }

    private static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    private static void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                // e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    private Connection getConnection(){
        try {
            Class.forName(CONSTANT.DRIVE_NAME);
            return DriverManager.getConnection(CONSTANT.DB_URL, CONSTANT.ID, CONSTANT.PASS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *Create user entity from result set
     * @param rs: result set from query database
     * @return user: user entity
     */
    @Override
    public User create(ResultSet rs) {
        try {
            User user = new User();

            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setDob(rs.getDate("dob"));
            user.setAvt(rs.getString("avt"));
            user.setPhone(rs.getString("phone"));
            user.setRole(1);

            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;

    }
}
