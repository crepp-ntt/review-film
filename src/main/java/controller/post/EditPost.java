package controller.post;

import com.google.gson.Gson;
import model.dto.PostDTO;
import service.PostService;
import util.AppUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/edit-post")
public class EditPost extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> data = new HashMap<>();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        //get parameters from form
        String title = request.getParameter("title");
        long rate = Long.parseLong(request.getParameter("rate"));
        String content = request.getParameter("content");
        String filmName = request.getParameter("filmName");
        long postId = Long.parseLong(request.getParameter("postId"));

        if (title.equals("") || content.equals("") || filmName.equals("")) {
            data.put("false", "Please input all field!!");
        } else {

            //create service, dto object
            PostService postService = new PostService();
            PostDTO postDTO = postService.getPost(postId);

            postDTO.setTitle(title);
            postDTO.setContent(content);
            postDTO.setRate(rate);
            postDTO.setFilmName(filmName);


            if (!AppUtils.getLoginedUser(request.getSession()).getUsername().equals(postDTO.getUsername())) {
                data.put("false", "Can not edit post!");
            } else if (postService.updatePost(postDTO) == 1) {
                data.put("success", "Edit post successful!");
            } else {
                data.put("false", "Can not edit post!");
            }

        }
        String json = new Gson().toJson(data);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long postId = Long.parseLong(request.getParameter("postId"));
        PostService postService = new PostService();
        PostDTO post = postService.getPost(postId);
        request.setAttribute("title", "Edit post: " + post.getId());
        request.setAttribute("post", post);
        request.setAttribute("user", AppUtils.getLoginedUser(request.getSession()));
        request.getRequestDispatcher("edit_post.jsp").forward(request, response);
    }
}
