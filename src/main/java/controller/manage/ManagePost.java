package controller.manage;

import com.google.gson.Gson;
import model.dto.PostDTO;
import service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/manage-post")
public class ManagePost extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> data = new HashMap<>();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String status =  request.getParameter("status");
        long postId = Long.parseLong(request.getParameter("postId"));

        PostService postService = new PostService();
        PostDTO post = postService.getPost(postId);
        post.setStatus(status);
        postService.updatePost(post);
        String result = "";
        if(status.equals("ACCEPTED")){
            result +="<div class=\"form-group table-detail lable-detail\">\n" +
                    "                                                                <div class=\"col-md-3\"></div>\n" +
                    "                                                                <span class=\"label label-success\"\n" +
                    "                                                                      style=\"font-size: 15px\">ACCEPTED</span>\n" +
                    "                                                            </div>";
        }
        else
            result +="<div class=\"form-group table-detail lable-detail\">\n" +
                    "                                                                <div class=\"col-md-3\"></div>\n" +
                    "                                                                <span class=\"label label-danger\"\n" +
                    "                                                                      style=\"font-size: 15px\">DECLINED</span>\n" +
                    "                                                            </div>";
        data.put("result", result);
        String json = new Gson().toJson(data);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long postId = Long.parseLong(request.getParameter("postId"));

        PostService postService = new PostService();
        PostDTO post = postService.getPost(postId);
        request.setAttribute("post", post);
        request.setAttribute("title", "Post:" + post.getTitle());
        request.getRequestDispatcher("manage_post.jsp").forward(request, response);
    }
}
