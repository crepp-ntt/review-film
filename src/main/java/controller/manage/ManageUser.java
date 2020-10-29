package controller.manage;

import com.google.gson.Gson;
import model.dto.UserDTO;
import service.UserService;
import util.AppUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/manage-user")
public class ManageUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> data = new HashMap<>();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String status = request.getParameter("status");

        //get userdto by username
        UserService userService = new UserService();
        UserDTO user = userService.getUser(username);

        //set user status and update
        user.setStatus(status);
        userService.updateUser(user);

        String result = "";
        if(status.equals("Active")){
            result += "<div class=\"form-group table-detail lable-detail\">\n" +
                    "                                                                <div class=\"col-md-3\"></div>\n" +
                    "                                                                <span class=\"label label-success\"\n" +
                    "                                                                      style=\"font-size: 15px\">ACTIVED</span>\n" +
                    "                                                            </div>\n" +
                    "                                                            <div class=\"form-group\">\n" +
                    "                                                                <div class=\"col-md-3\"></div>\n" +
                    "                                                                <h4 class=\"m-t-10 header-title col-md-6\"><b>Action</b>\n" +
                    "                                                                </h4>\n" +
                    "                                                            </div>\n" +
                    "                                                            <div class=\"form-group\">\n" +
                    "                                                                <button class=\"m-t-10 btn btn-white btn-block text-uppercase waves-effect waves-light\"\n" +
                    "                                                                        data-type=\"Block\" onclick=\"changeStatus(event, this.getAttribute('data-type'))\">\n" +
                    "                                                                    Block\n" +
                    "                                                                </button>\n" +
                    "\n" +
                    "                                                            </div>\n" +
                    "                                                            <div class=\"form-group\">\n" +
                    "                                                                <button class=\"btn btn-pink btn-block text-uppercase waves-effect waves-light\"\n" +
                    "                                                                        data-type=\"Ban\" onclick=\"changeStatus(event, this.getAttribute('data-type'))\">\n" +
                    "                                                                    Ban\n" +
                    "                                                                </button>\n" +
                    "\n" +
                    "                                                            </div>";
        } else if(status.equals("Block")){
            result += "<div class=\"form-group table-detail lable-detail\">\n" +
                    "                                                                <div class=\"col-md-3\"></div>\n" +
                    "                                                                <span class=\"label label-warning\"\n" +
                    "                                                                      style=\"font-size: 15px\">BLOCKED</span>\n" +
                    "                                                            </div>\n" +
                    "\n" +
                    "                                                            <div class=\"form-group\">\n" +
                    "                                                                <div class=\"col-md-3\"></div>\n" +
                    "                                                                <h4 class=\"m-t-10 header-title col-md-6\"><b>Action</b>\n" +
                    "                                                                </h4>\n" +
                    "                                                            </div>\n" +
                    "                                                            <div class=\"form-group\">\n" +
                    "                                                                <button class=\"m-t-10 btn btn-primary btn-block text-uppercase waves-effect waves-light\"\n" +
                    "                                                                        data-type=\"Active\" onclick=\"changeStatus(event, this.getAttribute('data-type'))\">\n" +
                    "                                                                    Unblock\n" +
                    "                                                                </button>\n" +
                    "\n" +
                    "                                                            </div>\n" +
                    "                                                            <div class=\"form-group\">\n" +
                    "                                                                <button class=\"btn btn-pink btn-block text-uppercase waves-effect waves-light\"\n" +
                    "                                                                        data-type=\"Ban\" onclick=\"changeStatus(event, this.getAttribute('data-type'))\">\n" +
                    "                                                                    Ban\n" +
                    "                                                                </button>\n" +
                    "\n" +
                    "                                                            </div>";
        }else {
            result += "<div class=\"form-group table-detail lable-detail\">\n" +
                    "                                                                <div class=\"col-md-3\"></div>\n" +
                    "                                                                <span class=\"label label-danger\"\n" +
                    "                                                                      style=\"font-size: 15px\">BANNED</span>\n" +
                    "                                                            </div>\n" +
                    "                                                            <div class=\"form-group\">\n" +
                    "                                                                <div class=\"col-md-3\"></div>\n" +
                    "                                                                <h4 class=\"m-t-10 header-title col-md-6\"><b>Action</b>\n" +
                    "                                                                </h4>\n" +
                    "                                                            </div>\n" +
                    "                                                            <div class=\"form-group\">\n" +
                    "                                                                <button class=\"m-t-10 btn btn-primary btn-block text-uppercase waves-effect waves-light\"\n" +
                    "                                                                        data-type=\"Active\" onclick=\"changeStatus(event, this.getAttribute('data-type'))\">\n" +
                    "                                                                    Unban\n" +
                    "                                                                </button>\n" +
                    "\n" +
                    "                                                            </div>\n" +
                    "                                                            <div class=\"form-group\">\n" +
                    "                                                                <button class=\"btn btn-white btn-block text-uppercase waves-effect waves-light\"\n" +
                    "                                                                        data-type=\"Block\" onclick=\"changeStatus(event, this.getAttribute('data-type'))\">\n" +
                    "                                                                    Block\n" +
                    "\n" +
                    "                                                                </button>\n" +
                    "\n" +
                    "                                                            </div>";
        }
        data.put("result", result);
        String json = new Gson().toJson(data);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        UserService userService = new UserService();
        UserDTO user = userService.getUser(username);

        request.setAttribute("title", "User: " + username);
        request.setAttribute("manageUser", user);
        request.setAttribute("user", AppUtils.getLoginedUser(request.getSession()));
        request.getRequestDispatcher("manage_user.jsp").forward(request, response);
    }
}
