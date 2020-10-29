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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/get-manage-post")
public class GetManagePosts extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> data = new HashMap<>();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        int currentPage = 1;
        if (request.getParameter("currentPage") != null)
            currentPage = Integer.parseInt(request.getParameter("currentPage"));

        PostService postService = new PostService();
        List<PostDTO> allPost = postService.getAllPosts();

        float itemPerPage = 10;
        int temp = (int)itemPerPage;
        int skipItems = (currentPage - 1) * (int)itemPerPage;
        int totalPage = (int) Math.ceil(allPost.size() / itemPerPage);
        List<PostDTO> posts = new ArrayList<>();
        for (int i = 0; i < allPost.size(); i++) {
            if (i < skipItems)
                continue;
            if (temp == 0)
                break;
            posts.add(allPost.get(i));
            temp--;
        }
        String result = "";
        for(PostDTO post: posts){
            result += "<tr>\n" +
                    "                                            <th scope=\"row\">"+ post.getId() +"</th>\n" +
                    "                                            <td>"+post.getTitle()+"</td>\n" +
                    "                                            <td>"+post.getStatus()+"</td>\n" +
                    "                                            <td><a href=\"manage-post?postId="+post.getId() +"\" class=\"on-default edit-row\"><i class=\"fa fa-pencil\"></i></a>\n" +
                    "                                            </td>\n" +
                    "                                        </tr>";
        }

        String pagination = "";
        if (currentPage != 1)
            pagination += "<li class=\"page-item\" data-page=\"" + (currentPage - 1) +"\" onclick=\"pagination(event, this.getAttribute('data-page'))\"><a class=\"page-link\" href=\"javascript:void(0)\">Previous</a></li>\n";
        if(currentPage > 1)
            pagination +=   "<li class=\"page-item\" data-page=\"" + (currentPage - 1) +"\" onclick=\"pagination(event, this.getAttribute('data-page'))\"><a class=\"page-link\" href=\"javascript:void(0)\" >"+ (currentPage - 1) +"</a></li>\n";
        pagination +=       "<li class=\"page-item active\"><a class=\"page-link\" href=\"javascript:void(0)\" tabindex=\"-1\">"+ currentPage +"</a></li>\n";
        if(currentPage < totalPage)
            pagination +=   "<li class=\"page-item\" data-page=\"" + (currentPage + 1) +"\" onclick=\"pagination(event, this.getAttribute('data-page'))\"><a class=\"page-link\" href=\"javascript:void(0)\">"+ (currentPage + 1) +"</a></li>\n" ;

        if(currentPage < totalPage)
            pagination +=   "<li class=\"page-item\" data-page=\"" + (currentPage + 1) +"\" onclick=\"pagination(event, this.getAttribute('data-page'))\"><a class=\"page-link\" href=\"javascript:void(0)\">Next</a></li>\n" ;


        data.put("result", result);
        data.put("pagination", pagination);
        String json = new Gson().toJson(data);
        response.getWriter().write(json);

    }
}
