package controller.user;

import com.google.gson.Gson;
import constant.Constant;
import model.dao.iUserDao;
import model.dao.impl.UserDao;
import model.entity.User;
import service.UserService;
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
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/login")
@MultipartConfig
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> data = new HashMap<>();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService userService = new UserService();
        if(userService.getUser(username)== null){
                data.put("false", "Your account not exists");
        }
        else if( userService.getUser(username).getStatus().equals("Ban")){
            data.put("false", "Your account has been ban");
        }
        else if (!userService.login(request, username, password)) {
            data.put("false", "Invalid username or password");
        } else {
            if(AppUtils.getLoginedUser(request.getSession()).getRole() == 0)
                data.put("success", "/manage-posts");
            else
                data.put("success", "/");

        }
        String json = new Gson().toJson(data);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(AppUtils.getLoginedUser(request.getSession()) == null) {
            request.setAttribute("title", "Login");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else
            response.sendRedirect("/");
    }


}
