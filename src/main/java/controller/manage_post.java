package controller;

import model.dto.PostDTO;
import service.PostService;
import util.AppUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/manage_post")
public class manage_post extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostService postService = new PostService();
        List<PostDTO> posts = postService.getAllPosts();

        request.setAttribute("title", "Post Management");
        request.setAttribute("posts", posts);
        request.setAttribute("user", AppUtils.getLoginedUser(request.getSession()));
        request.getRequestDispatcher("manage_post.jsp").forward(request, response);
    }
}
