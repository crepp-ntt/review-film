package model.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import model.dao.iCommentDao;
import model.dao.impl.CommentDao;
import model.dto.UserDTO;
import model.entity.Comment;

import java.io.IOException;
import java.util.List;

public class CommentService {
    private iCommentDao dao = new CommentDao();

    public List<Comment> getPostComment(long postId){
        return dao.findByPostId(postId);
    }

    public List<Comment> getUserComment(String username){
        return dao.findByUsername(username);
    }
//    public int saveComment(String username, String userAvt, long postId, String content){
//        Comment comment = new Comment(username, userAvt, postId, content);
//        return dao.insert(comment);
//    }

    public int createComment(String json) throws IOException {
        return dao.insert(jsonToModel(json));
    }

    private Comment jsonToModel(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ObjectReader reader = mapper.reader(Comment.class);
        MappingIterator elements = reader.readValues(json);
        Comment comment = (Comment) elements.next();
        return comment;
    }
}
