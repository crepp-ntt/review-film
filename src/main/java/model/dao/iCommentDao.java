package model.dao;

import model.entity.Comment;

import java.sql.ResultSet;
import java.util.List;

public interface iCommentDao extends iDAO<Comment>{


    List<Comment> findByPostId(long postId);

    List<Comment> findByUsername(String username);

    @Override
    Comment findOne(Object id);


    @Override
    int delete(Comment T);

    @Override
    int insert(Comment comment);

    @Override
    int update(Comment comment);

    /**
     * Create Comment entity from ResultSet
     * @param rs: ResultSet from query database
     * @return comment: comment entity
     */
    @Override
    Comment create(ResultSet rs);
}
