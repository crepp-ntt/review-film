package model.dao.impl;

import util.ConnectionUtils;
import model.dao.iPostDao;
import model.entity.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDao implements iPostDao {
    private static final
    String FIND_ALL = "SELECT * FROM posts";
    private static final
    String FIND_ALL_BY_STATUS_SEARCH = "SELECT * FROM posts WHERE current_status LIKE ? AND (UPPER(title) LIKE ? OR UPPER(content) LIKE ?)";
    private static final
    String FIND_ONE = "SELECT * FROM posts WHERE id=?";
    private static final
    String INSERT = "INSERT INTO posts(username, user_avt, title, rate, content, current_status, date, film_name) VALUES (?,?,?,?,?,?,?,?)";
    private static final
    String UPDATE = "UPDATE posts SET username=?, user_avt=?, title=?, rate=?, content=?, current_status=?, date=?,film_name=? WHERE id=?";
    private static final
    String FIND_BY_USERNAME = "SELECT * FROM posts WHERE username=? ORDER BY id DESC";
    private static final
    String FIND_TOP_POST = "SELECT p.*, COUNT(v.id) AS V " +
            "FROM posts p JOIN votes v on p.id = v.post_id " +
            "WHERE v.vote='UP' GROUP BY p.id ORDER BY v DESC LIMIT 3";

    @Override
    public List<Post> findAll(String status, String search) {
        PreparedStatement stmt = null;
        List<Post> posts = new ArrayList<>();

        try (Connection conn = ConnectionUtils.getConnection()) {
            stmt = conn.prepareStatement(FIND_ALL_BY_STATUS_SEARCH);
            stmt.setString(1, "%" + status + "%");
            stmt.setString(2, "%" + search.toUpperCase() + "%");
            stmt.setString(3, "%" + search.toUpperCase() + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                posts.add(create(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return posts;
    }

    @Override
    public List<Post> findTopPost() {
        PreparedStatement stmt = null;

        List<Post> posts = new ArrayList<>();
        try (Connection conn = ConnectionUtils.getConnection()) {
            stmt = conn.prepareStatement(FIND_TOP_POST);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Post post = create(rs);
                post.setUpVotes(rs.getInt("V"));
                posts.add(post);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return posts;
    }

    @Override
    public List<Post> findAll() {
        PreparedStatement stmt = null;
        List<Post> posts = new ArrayList<>();

        try (Connection conn = ConnectionUtils.getConnection()) {
            stmt = conn.prepareStatement(FIND_ALL);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                posts.add(create(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return posts;
    }

    @Override
    public List<Post> findByUsername(String username) {
        PreparedStatement stmt = null;

        try (Connection conn = ConnectionUtils.getConnection()) {
            List<Post> posts = new ArrayList<>();
            stmt = conn.prepareStatement(FIND_BY_USERNAME);
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                posts.add(create(rs));
            return posts;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Post findOne(Object id) {
        PreparedStatement stmt = null;


        try (Connection conn = ConnectionUtils.getConnection()) {
            stmt = conn.prepareStatement(FIND_ONE);
            stmt.setLong(1, (long) id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
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
        PreparedStatement stmt = null;

        try (Connection conn = ConnectionUtils.getConnection()) {
            stmt = conn.prepareStatement(INSERT);
            stmt.setString(1, post.getUsername());
            stmt.setString(2, post.getUserAvt());
            stmt.setString(3, post.getTitle());
            stmt.setLong(4, post.getRate());
            stmt.setString(5, post.getContent());
            stmt.setString(6, "PENDING");

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
        PreparedStatement stmt = null;

        try (Connection conn = ConnectionUtils.getConnection()) {
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

//    private static void close(Connection conn) {
//        if (conn != null) {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                // e.printStackTrace();
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    private static void close(Statement stmt) {
//        if (stmt != null) {
//            try {
//                stmt.close();
//            } catch (SQLException e) {
//                // e.printStackTrace();
//                throw new RuntimeException(e);
//            }
//        }
//    }

//    private Connection getConnection() {
//        try {
//            Class.forName(Constant.DRIVE_NAME);
//            return DriverManager.getConnection(Constant.DB_URL, Constant.ID, Constant.PASSWORD);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}
