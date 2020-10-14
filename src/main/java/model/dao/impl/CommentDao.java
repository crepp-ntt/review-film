//package model.dao.impl;
//
//import constant.CONSTANT;
//import model.dao.iCommentDao;
//import model.entity.Comment;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CommentDao implements iCommentDao {
//
//
//
//    @Override
//    public List<Comment> findAll() {
//        List<Comment> comments = new ArrayList<>();
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        try {
//            conn = getConnection();
//            stmt = conn.prepareStatement(FIND_ADD);
//            ResultSet rs = stmt.executeQuery();
//
//            while(rs.next()){
//                comments.add(create(rs));
//            }
//
//            return comments;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public Comment findOne(Object id) {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        try{
//            conn = getConnection();
//            stmt = conn.prepareStatement(FIND_ONE);
//            stmt.setLong(1,(long)id);
//
//            ResultSet rs = stmt.executeQuery();
//            return create(rs);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return null;
//    }
//
//    @Override
//    public int delete(Comment T) {
//        return 0;
//    }
//
//    @Override
//    public int insert(Comment comment) {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//
//        try {
//            conn = getConnection();
//            stmt = conn.prepareStatement(INSERT);
//            stmt.setLong(1, comment.getId());
//            stmt.setString(2, comment.getUsername());
//            stmt.setString(3, comment.getUserAvt());
//            stmt.setString(4, comment.getContent());
//            return stmt.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return 0;
//    }
//
//    @Override
//    public int update(Comment comment) {
//        return 0;
//    }
//
//    @Override
//    public Comment create(ResultSet rs) {
//
//        try {
//            Comment comment = new Comment();
//            comment.setId(rs.getLong("id"));
//            comment.setUsername(rs.getString("username"));
//            comment.setUserAvt(rs.getString("user_avt"));
//            comment.setContent(rs.getString("content"));
//
//            return comment;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return null;
//    }
//
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
//
//    private Connection getConnection(){
//        try {
//            Class.forName(CONSTANT.DRIVE_NAME);
//            return DriverManager.getConnection(CONSTANT.DB_URL, CONSTANT.ID, CONSTANT.PASS);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
