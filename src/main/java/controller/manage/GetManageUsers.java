package controller.manage;

import com.google.gson.Gson;
import model.dto.PostDTO;
import model.dto.UserDTO;
import service.PostService;
import service.UserService;

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

@WebServlet("/get-manage-user")
public class GetManageUsers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> data = new HashMap<>();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        int currentPage = 1;
        if (request.getParameter("currentPage") != null)
            currentPage = Integer.parseInt(request.getParameter("currentPage"));

        UserService userService = new UserService();
        List<UserDTO> allUser = userService.getAllUser();

        float itemPerPage = 10;
        int temp = (int)itemPerPage;
        int skipItems = (currentPage - 1) * (int)itemPerPage;
        int totalPage = (int) Math.ceil(allUser.size() / itemPerPage);
        List<UserDTO> users = new ArrayList<>();
        for (int i = 0; i < allUser.size(); i++) {
            if (i < skipItems)
                continue;
            if (temp == 0)
                break;
            users.add(allUser.get(i));
            temp--;
        }
        String result = "";
        for(UserDTO user: users){
            result += "<tr>\n" +
                    "                                            <th scope=\"row\">"+ user.getUsername() +"</th>\n" +
                    "                                            <td>"+user.getName()+"</td>\n" +
                    "                                            <td>"+user.getStatus()+"</td>\n" +
                    "                                            <td><a href=\"manage-user?username="+user.getUsername() +"\" class=\"on-default edit-row\"><i class=\"fa fa-pencil\"></i></a>\n" +
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
