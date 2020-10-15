package model.dao.impl;

import constant.CONSTANT;
import model.dao.iPostDao;
import model.entity.Post;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDao implements iPostDao {
    private static final
    String FIND_ALL = "SELECT * FROM posts";
    private static final
    String FIND_ONE = "SELECT * FROM posts WHERE id=?";
    private static final
    String INSERT = "INSERT INTO posts(username, user_avt, title, rate, content, current_status, date, film_name) VALUES (?,?,?,?,?,?,?,?)";
    private static final
    String UPDATE = "UPDATE posts SET username=?, user_avt=?, title=?, rate=?, content=?, current_status=?, date=?,film_name=? WHERE id=?";

    @Override
    public List<Post> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            List<Post> posts = new ArrayList<>();
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_ALL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                posts.add(create(rs));
            }
            return posts;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(stmt);
            close(conn);
        }
        return null;
    }

    @Override
    public Post findOne(Object id) {
        Connection conn = null;
        PreparedStatement stmt = null;


        try {
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_ONE);
            stmt.setLong(1, (long) id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
                return create(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public int delete(Post T) {
        return 0;
    }

    @Override
    public int insert(Post post) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(INSERT);
            stmt.setString(1, post.getUsername());
            stmt.setString(2, post.getUserAvt());
            stmt.setString(3, post.getTitle());
            stmt.setLong(4, post.getRate());
            stmt.setString(5, post.getContent());
            stmt.setString(6, post.getCurrentStatus());

            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            stmt.setDate(7, sqlDate);
            stmt.setString(8, post.getFilmName());



            return stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    @Override
    public int update(Post post) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setString(1, post.getUsername());
            stmt.setString(2, post.getUserAvt());
            stmt.setString(3, post.getTitle());
            stmt.setLong(4, post.getRate());
            stmt.setString(5, post.getContent());
            stmt.setString(6, post.getCurrentStatus());

            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            stmt.setDate(7, sqlDate);
            stmt.setString(8, post.getFilmName());

            stmt.setLong(9, post.getId());

            return stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }


    @Override
    public Post create(ResultSet rs) {
        Post post = new Post();
        try {
            post.setId(rs.getLong("id"));
            post.setUsername(rs.getString("username"));
            post.setUserAvt(rs.getString("user_avt"));
            post.setTitle(rs.getString("title"));
            post.setFilmName(rs.getString("film_name"));
            post.setRate(rs.getLong("rate"));
            post.setContent(rs.getString("content"));
            post.setCurrentStatus(rs.getString("current_status"));
            post.setDate(rs.getDate("date"));

            return post;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
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

    private Connection getConnection() {
        try {
            Class.forName(CONSTANT.DRIVE_NAME);
            return DriverManager.getConnection(CONSTANT.DB_URL, CONSTANT.ID, CONSTANT.PASS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
