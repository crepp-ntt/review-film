package controller;

import com.google.gson.Gson;
import constant.Constant;
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
import java.util.regex.Pattern;

@WebServlet("/change-password")
public class ChangePassword extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> data = new HashMap<>();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String oldPass = request.getParameter("oldPass");
        String newPass = request.getParameter("newPass");
        String confirm = request.getParameter("confirm");

        UserService userService = new UserService();
        if (!userService.checkPass(AppUtils.getLoginedUser(request.getSession()).getPassword(), oldPass)) {
            data.put("false", "Old password is incorrect!");
        } else if(newPass.equals(oldPass)){
            data.put("false", "Your new password must be different from your previous password");
        }
        else if (!newPass.equals(confirm)) {
            data.put("false", "Confirm password does not match");
        } else if (!Pattern.matches(Constant.PASSWORD_PATTERN, newPass)) {
            data.put("false", "Password wrong format");
        } else {
            userService.changePass(AppUtils.getLoginedUser(request.getSession()).getUsername(), newPass);
            data.put("success", "Change password successful");
        }
        String json = new Gson().toJson(data);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Change Password");
        request.setAttribute("user", AppUtils.getLoginedUser(request.getSession()));
        request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
    }
}
