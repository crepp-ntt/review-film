package controller;

import com.google.gson.Gson;
import model.dao.iPostDao;
import model.dao.impl.PostDao;
import model.dto.PostDTO;
import model.entity.Post;
import model.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/create_post")
@MultipartConfig
public class create_post extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> data = new HashMap<>();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String title = request.getParameter("title");
        String rate = request.getParameter("rate");
        String content = request.getParameter("content");
        String filmName = request.getParameter("filmName");

        PostService postService = new PostService();

        PostDTO postDTO = new PostDTO();

        postDTO.setTitle(title);
        postDTO.setRate(Long.parseLong(rate));
        postDTO.setContent(content);
        postDTO.setFilm(filmName);

        if(postService.savePost(postDTO) == 1){
            data.put("success","Create post successful!");
        }
        else{
            data.put("false", "Can not create post!");
        }

        String json = new Gson().toJson(data);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("create_post.jsp");
    }
}
