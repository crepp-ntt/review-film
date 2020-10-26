package model.dao.impl;

import util.ConnectionUtils;
import model.dao.iVoteDao;
import model.entity.Vote;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoteDao implements iVoteDao {

    private static final
    String FIND_BY_POST_ID ="SELECT * FROM votes WHERE post_id=?";

    private static final
    String FIND_BY_USERNAME ="SELECT * FROM votes WHERE username=?";

    private static final
    String FIND_BY_POST_ID_USERNAME = "SELECT * FROM votes WHERE post_id=? AND username=?";

    private static final
    String UPDATE_VOTE = "UPDATE votes SET vote=? WHERE id=?";

    private static final
    String INSERT = "INSERT INTO votes(username, post_id, vote, post_title) values (?,?,?,?)";

    @Override
    public List<Vote> findAll() {
        return null;
    }

    @Override
    public List<Vote> findByPostId(long postId) {
        PreparedStatement stmt = null;

        try (Connection conn = ConnectionUtils.getConnection()){
            List<Vote> votes = new ArrayList<>();
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
    public List<Vote> findByUsername(String username) {
        PreparedStatement stmt = null;

        try (Connection conn = ConnectionUtils.getConnection()){
            List<Vote> votes = new ArrayList<>();
            stmt = conn.prepareStatement(FIND_BY_USERNAME);
            stmt.setString(1, username);

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
    public Vote findCheckVote(long postId, String username) {
        PreparedStatement stmt = null;

        try(Connection conn = ConnectionUtils.getConnection()) {
            stmt = conn.prepareStatement(FIND_BY_POST_ID_USERNAME);
            stmt.setLong(1, postId);
            stmt.setString(2, username);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
                return create(rs);
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
        PreparedStatement stmt = null;

        try (Connection conn = ConnectionUtils.getConnection()){
            stmt = conn.prepareStatement(INSERT);
            stmt.setString(1, vote.getUsername());
            stmt.setLong(2, vote.getPostId());
            stmt.setString(3, vote.getVote());
            stmt.setString(4, vote.getPostTitle());

            return stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Vote vote) {
        PreparedStatement stmt = null;

        try(Connection conn = ConnectionUtils.getConnection()) {
            String type = "";
            if(vote.getVote().equals("UP"))
                type += "DOWN";
            else
                type += "UP";
            stmt = conn.prepareStatement(UPDATE_VOTE);
            stmt.setString(1, type);
            stmt.setLong(2, vote.getId());
            return stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
            vote.setPostTitle(rs.getString("post_title"));


            return vote;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


}
