package controller;

import com.google.gson.Gson;
import model.dao.impl.UserDao;
import model.entity.User;

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

@WebServlet("/signup")
@MultipartConfig
public class signup extends HttpServlet {
    private static final String EMAIL_PATTERN = "^(.+)@(.+)$";
    private static final String USERNAME_PATTERN = "[a-z0-9_]{6,12}";
    private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{6,20})";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String> data = new HashMap<>();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String pass1 = request.getParameter("password");
        String pass2 = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");


        UserDao userDao = new UserDao();
        User user = new User();
        user.setUsername(username);
        user.setPassword(pass1);
        user.setName(name);
        user.setEmail(email);
        if (userDao.findOne(username) != null) {
            data.put("false", "Username already exists!");
        } else if (!pass1.equals(pass2)) {
            data.put("false", "Confirm password does not match!");
        } else if (checkUserInfo(user) == 0) {
            data.put("false", "Your info has wrong format!");
        } else {
            userDao.insert(user);
            data.put("success", "Create account successful!");
        }

        String json = new Gson().toJson(data);
        response.getWriter().write(json);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "SignUp");
        request.getRequestDispatcher("signup.jsp").forward(request,response);
    }

    private int checkUserInfo(User user) {
        if (!Pattern.matches(USERNAME_PATTERN, user.getUsername()))
            return 0;
        if (!Pattern.matches(PASSWORD_PATTERN, user.getPassword()))
            return 0;
        if (!Pattern.matches(EMAIL_PATTERN, user.getEmail()))
            return 0;
        return 1;
    }
}
