package model.dao;

import model.entity.Vote;

import java.sql.ResultSet;
import java.util.List;

public interface iVoteDao extends iDAO<Vote>{
    @Override
    List<Vote> findAll();

    /**
     * Get all vote from database use postId
     * @param postId
     * @return List<Vote>: List of votes
     */
    List<Vote> findByPostId(long postId);

    @Override
    Vote findOne(Object input);

    @Override
    int delete(Vote T);

    @Override
    int insert(Vote vote);

    @Override
    int update(Vote vote);


    @Override
    Vote create(ResultSet rs);
}
