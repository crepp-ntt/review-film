package controller;

import com.google.gson.Gson;
import model.dto.PostDTO;
import model.entity.Comment;
import model.service.CommentService;
import model.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/comment")
public class comment extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> data = new HashMap<>();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String json = request.getParameter("json");
        if (json != null) {
            CommentService commentService = new CommentService();
            commentService.createComment(json);
        }
        data.put("false", "Can not change profile");
        String res = new Gson().toJson(data);
        response.getWriter().write(res);
//        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> data = new HashMap<>();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        long postId = Long.parseLong(request.getParameter("postId"));
        int currentPage = 1;
        if (request.getParameter("currentPage") != null)
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        CommentService commentService = new CommentService();
        List<Comment> allComments = commentService.getPostComment(postId);

        float itemPerPage = 3;
        int temp = (int) itemPerPage;
        int skipItems = (currentPage - 1) * (int) itemPerPage;
        int totalPage = (int) Math.ceil(allComments.size() / itemPerPage);
        List<Comment> comments = new ArrayList<>();
        for (int i = 0; i < allComments.size(); i++) {
            if (i < skipItems)
                continue;
            if (temp == 0)
                break;
            comments.add(allComments.get(i));
            temp--;
        }
        String result = "";
        for (Comment item : comments) {
            result += "<div class=\"form-group card-box\"><div class=\"col-md-3\">\n" +
                    "                                                        <img src=\"" + item.getUserAvt() + "\" alt=\"your image\"\n" +
                    "                                                             style=\"width: 75px; height: 75px\"/>\n" +
                    "\n" +
                    "                                                    </div>\n" +
                    "                                                    <div class=\"col-md-9\">\n" +
                    "                                                        <div class=\"col-md-2\"></div>\n" +
                    "                                                        <div class=\"col-md-12\">\n" +
                    "                                                            <label class=\"\">" + item.getUsername() + ":</label>\n" +
                    "                                                            <span>" + item.getContent() + "</span>\n" +
                    "                                                        </div>\n" +
                    "                                                    </div></div>";
        }
        String pagination = "";
        if (currentPage != 1)
            pagination += "<li class=\"page-item\" data-offset=\"" + (currentPage - 1) + "\"><a class=\"page-link\" href=\"javascript:void(0)\">Previous</a></li>\n";
        if (currentPage > 1)
            pagination += "<li class=\"page-item\" data-offset=\"" + (currentPage - 1) + "\"><a class=\"page-link\" href=\"javascript:void(0)\" >" + (currentPage - 1) + "</a></li>\n";
        pagination += "<li class=\"page-item active\"><a class=\"page-link\" href=\"javascript:void(0)\" tabindex=\"-1\">" + currentPage + "</a></li>\n";
        if (currentPage < totalPage)
            pagination += "<li class=\"page-item\" data-offset=\"" + (currentPage + 1) + "\"><a class=\"page-link\" href=\"javascript:void(0)\">" + (currentPage + 1) + "</a></li>\n";

        if (currentPage < totalPage)
            pagination += "<li class=\"page-item\" data-offset=\"" + (currentPage + 1) + "\"><a class=\"page-link\" href=\"javascript:void(0)\">Next</a></li>\n";

        data.put("result", result);
        data.put("pagination", pagination);
        String json = new Gson().toJson(data);
        response.getWriter().write(json);
    }
}
