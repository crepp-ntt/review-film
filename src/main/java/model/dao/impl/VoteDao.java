package model.dao.impl;

import constant.CONSTANT;
import model.dao.iVoteDao;
import model.entity.Vote;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoteDao implements iVoteDao {

    private static final
    String FIND_BY_POST_ID ="SELECT * FROM votes WHERE post_id=?";

    @Override
    public List<Vote> findAll() {
        return null;
    }

    @Override
    public List<Vote> findByPostId(long postId) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            List<Vote> votes = new ArrayList<>();
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_BY_POST_ID);
            stmt.setLong(1, postId);

            ResultSet rs = stmt.executeQuery();
            while(rs.next())
                votes.add(create(rs));
            return votes;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Vote findOne(Object input) {
        return null;
    }

    @Override
    public int delete(Vote T) {
        return 0;
    }

    @Override
    public int insert(Vote vote) {
        return 0;
    }

    @Override
    public int update(Vote vote) {
        return 0;
    }

    @Override
    public Vote create(ResultSet rs) {

        try {
            Vote vote = new Vote();
            vote.setId(rs.getLong("id"));
            vote.setUsername(rs.getString("username"));
            vote.setPostId(rs.getLong("post_id"));
            vote.setVote(rs.getString("vote"));

            return vote;
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

    private Connection getConnection(){
        try {
            Class.forName(CONSTANT.DRIVE_NAME);
            return DriverManager.getConnection(CONSTANT.DB_URL, CONSTANT.ID, CONSTANT.PASS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
