package model.dao.impl;

import util.ConnectionUtils;
import constant.Constant;
import model.dao.iUserDao;
import model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDao implements iUserDao {
    private static final
    String FIND_ALL = "SELECT * FROM users";

    private static final
    String INSERT = "INSERT INTO users(username, password, name, email, status, avt) VALUES (?,?,?,?,?,?)";

    private static final
    String UPDATE = "UPDATE users SET name=?,email=?,dob=?,phone=?,avt=?,status=? WHERE username=?";

    private static final
    String FIND_ONE = "SELECT * FROM users WHERE username=?";

    private static final
    String CHANGE_PASS = "UPDATE users SET password=? WHERE username=?";



    @Override
    public List<User> findAll() {
        
        PreparedStatement stmt = null;
        List<User> users = new ArrayList<User>();
        try(Connection conn = ConnectionUtils.getConnection()){
            
            stmt = conn.prepareStatement(FIND_ALL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                users.add(create(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }


    @Override
    public int changePassword(String username, String password) {
        
        PreparedStatement stmt = null;
        try(Connection conn = ConnectionUtils.getConnection()){
            
            stmt = conn.prepareStatement(CHANGE_PASS);
            stmt.setString(1, password);
            stmt.setString(2, username);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findOne(Object username) {
        
        PreparedStatement stmt = null;
        try(Connection conn = ConnectionUtils.getConnection()){
            
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
    public int insert(User user) {
        
        PreparedStatement stmt = null;

        try(Connection conn = ConnectionUtils.getConnection()){
            
            stmt = conn.prepareStatement(INSERT);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getName());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, "Active");
            stmt.setString(6, Constant.DEFAULT_AVT);




            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(User user) {
        
        PreparedStatement stmt = null;

        try(Connection conn = ConnectionUtils.getConnection()){
            
            stmt = conn.prepareStatement(UPDATE);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setDate(3, user.getDob());
            stmt.setString(4, user.getPhone());
            stmt.setString(5, user.getAvt());
            stmt.setString(6,user.getStatus());
            stmt.setString(7,user.getUsername());


            return stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




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
            user.setRole(rs.getLong("role"));
            user.setStatus(rs.getString("status"));

            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;

    }
}
