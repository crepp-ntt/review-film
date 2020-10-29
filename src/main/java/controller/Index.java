package controller;

import model.dto.PostDTO;
import model.dto.UserDTO;
import service.PostService;
import service.UserService;
import util.AppUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/index")
public class Index extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PostService postService = new PostService();
        List<PostDTO> posts = postService.getTopPost();

        UserService userService = new UserService();
        List<UserDTO> users = userService.getTopUser();

        request.setAttribute("title", "List review");
        request.setAttribute("topPosts", posts);
        request.setAttribute("topUsers", users);
        request.setAttribute("user", AppUtils.getLoginedUser(request.getSession()));
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
}
