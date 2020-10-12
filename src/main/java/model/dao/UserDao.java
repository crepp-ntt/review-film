package model.dao;

import model.entity.User;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements DAO<User>{
    //PostgreSQL
    private static final String DRIVE_NAME = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/reviewer";
    private static final String ID = "crepp";
    private static final String PASS = "password";

    private static final String FIND_ALL = "SELECT * FROM users";
    private static final String INSERT = "INSERT INTO users(username, password, name, email) VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE users SET password=?,name=?,email=?,dob=?,phone=?,avt=? WHERE username=?";
    private static final String CHECK_EXISTS = "SELECT * FROM users WHERE username=?";



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
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setDob(rs.getDate("dob"));
                user.setAvt(rs.getString("avt"));
                user.setPhone(rs.getString("phone"));
                user.setRole(1);

                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(stmt);
            close(conn);
        }
        return users;
    }

    @Override
    public User findOne(int id) {
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
            Class.forName(DRIVE_NAME);
            return DriverManager.getConnection(DB_URL, ID, PASS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int isExists(String username){
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = getConnection();
            stmt = conn.prepareStatement(CHECK_EXISTS);
            stmt.setString(1, username);

             ResultSet rs =  stmt.executeQuery();
             if(rs.next())
                 return 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
