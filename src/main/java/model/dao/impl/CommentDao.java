package model.dao.impl;

import util.ConnectionUtils;
import model.dao.iCommentDao;
import model.entity.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDao implements iCommentDao {
    private static final
    String INSERT="INSERT INTO comments(username, user_avt, post_id, content) VALUES(?,?,?,?)";

    private static final
    String FIND_BY_POST_ID="SELECT * FROM comments WHERE post_id=? ORDER BY id DESC";

    private static final
    String FIND_BY_USERNAME="SELECT * FROM comments WHERE username=? ORDER BY id DESC";


    @Override
    public List<Comment> findAll() {
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
        return null;
    }

    @Override
    public Comment findOne(Object id) {
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

        return null;
    }

    @Override
    public int delete(Comment T) {
        return 0;
    }

    @Override
    public List<Comment> findByPostId(long postId) {
        PreparedStatement stmt = null;

        try(Connection conn = ConnectionUtils.getConnection()) {
            List<Comment> comments = new ArrayList<>();
            stmt = conn.prepareStatement(FIND_BY_POST_ID);
            stmt.setLong(1, postId);

            ResultSet rs = stmt.executeQuery();
            while(rs.next())
                comments.add(create(rs));
            return comments;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Comment> findByUsername(String username) {
        PreparedStatement stmt = null;

        try(Connection conn = ConnectionUtils.getConnection()) {
            List<Comment> comments = new ArrayList<>();
            stmt = conn.prepareStatement(FIND_BY_USERNAME);
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();
            while(rs.next())
                comments.add(create(rs));
            return comments;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public int insert(Comment comment) {
        PreparedStatement stmt = null;

        try (Connection conn = ConnectionUtils.getConnection()){
            stmt = conn.prepareStatement(INSERT);
            stmt.setString(1, comment.getUsername());
            stmt.setString(2, comment.getUserAvt());
            stmt.setLong(3, comment.getPostId());
            stmt.setString(4, comment.getContent());
            return stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    @Override
    public int update(Comment comment) {
        return 0;
    }

    @Override
    public Comment create(ResultSet rs) {

        try {
            Comment comment = new Comment();
            comment.setId(rs.getLong("id"));
            comment.setUsername(rs.getString("username"));
            comment.setUserAvt(rs.getString("user_avt"));
            comment.setPostId(rs.getLong("post_id"));
            comment.setContent(rs.getString("content"));

            return comment;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


}
