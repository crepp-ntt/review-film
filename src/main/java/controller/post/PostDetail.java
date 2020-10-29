package controller.post;

import model.dto.PostDTO;
import service.PostService;
import util.AppUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

@WebServlet("/post-detail")
public class PostDetail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = parseLong(request.getParameter("id"));
        PostService postService = new PostService();
        PostDTO postDTO = postService.getPost(id);
        request.setAttribute("post", postDTO);
        request.setAttribute("title", "Post: " + postDTO.getTitle());
        request.setAttribute("user", AppUtils.getLoginedUser(request.getSession()));
        request.getRequestDispatcher("post_detail.jsp").forward(request,response);
    }
}
