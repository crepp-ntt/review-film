package controller.post;

import com.google.gson.Gson;
import model.dto.PostDTO;
import service.PostService;
import util.AppUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/create-post")
@MultipartConfig
public class CreatePost extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> data = new HashMap<>();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        //get parameters from form
        String title = request.getParameter("title");
        String rate = request.getParameter("rate");
        String content = request.getParameter("content");
        String filmName = request.getParameter("filmName");

        if(title.equals("") || content.equals("") || filmName.equals("")){
            data.put("false", "Please input all field!!");
        }
        else {

            //create service, dto object
            PostService postService = new PostService();
            PostDTO postDTO = new PostDTO();


            postDTO.setTitle(title);
            postDTO.setRate(Long.parseLong(rate));
            postDTO.setContent(content);
            postDTO.setFilm(filmName);


            if (AppUtils.getLoginedUser(request.getSession()).getStatus().equals("Block")) { //check user status
                data.put("false", "Can not create post!");
            } else if (postService.savePost(request, postDTO) == 1) {
                data.put("success", "Create post successful!");
            } else {
                data.put("false", "Can not create post!");
            }
        }

        String json = new Gson().toJson(data);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = "Create review";
        request.setAttribute("title", title);
        request.setAttribute("user", AppUtils.getLoginedUser(request.getSession()));
        request.getRequestDispatcher("create_post.jsp").forward(request,response);
    }
}
