package model.dao;

import model.entity.Post;

import java.sql.ResultSet;
import java.util.List;

public interface iPostDao extends iDAO<Post> {

    /**
     * Find all post in database
     *
     * @return List<Post>: all posts in database
     */

    List<Post> findAll(String status, String search);

    List<Post> findByUsername(String username);

    List<Post> findTopPost();

    int deleteByIdArray(List<Long> id);

    @Override
    Post findOne(Object id);

    @Override
    int delete(Post T);

    @Override
    int insert(Post post);

    @Override
    int update(Post post);

    @Override
    Post create(ResultSet rs);
}
