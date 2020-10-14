package model.dao;

import model.entity.Post;

import java.sql.ResultSet;
import java.util.List;

public interface iPostDao extends DAO<Post>{

    /**
     * Find all post in database
     * @return List<Post>: all posts in database
     */
    @Override
    List<Post> findAll();

    @Override
    Post findOne(int id);

    @Override
    int delete(Post T);

    @Override
    int insert(Post post);

    @Override
    int update(Post post);

    @Override
    Post create(ResultSet rs);
}
