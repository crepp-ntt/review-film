package model.service;

import model.dao.iPostDao;
import model.dao.impl.PostDao;
import model.dto.PostDTO;
import model.entity.Post;

import java.util.ArrayList;
import java.util.List;

public class PostService {
    private final iPostDao dao = new PostDao();

    public List<PostDTO> getAllPosts(){
        List<PostDTO> postDTOs = new ArrayList<>();
        for(Post post : dao.findAll()){
            postDTOs.add(convertToDTO(post));
        }
        return postDTOs;
    }

    public PostDTO getPost(long id){
        Post post = dao.findOne(id);
        return convertToDTO(post);
    }


    public int savePost(PostDTO dto){
        Post post = convertToEntity(dto);
        return dao.insert(post);
    }

    public int updatePost(PostDTO dto){
        Post post = convertToEntity(dto);
        return dao.update(post);
    }

    private Post convertToEntity(PostDTO dto) {
        Post post = new Post();
        post.setId(dto.getId());
        post.setTitle(dto.getTitle());
        post.setRate(dto.getRate());
        post.setFilmName(dto.getFilmName());
        post.setContent(dto.getContent());
        return post;
    }

    private PostDTO convertToDTO(Post post) {
        PostDTO dto = new PostDTO();
        dto.setId(post.getId());
        dto.setContent(post.getContent());
        dto.setFilm(post.getFilmName());
        dto.setRate(post.getRate());
        dto.setTitle(post.getTitle());
        return dto;
    }
}
