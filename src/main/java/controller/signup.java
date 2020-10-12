package controller;

import model.dao.UserDao;
import model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/signup")
@MultipartConfig
public class signup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/plain");


//        response.getOutputStream().println("<h1>Hello " + "crepp" + "!</h1>");
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        response.sendRedirect("login.jsp");
        UserDao userDao = new UserDao();
        if(userDao.isExists(username) == 1){
//            out.println("<script type=\"text/javascript\">");
//            out.println("alert('User or password incorrect');");
//            out.println("location='signup.jsp';");
//            out.println("</script>");
//            out.println("<script type=\"text/javascript\">");
//            out.println("alert('Username cannot be used. Please choose another username.');");
//            out.println("</script>");
//            response.sendRedirect("signup.jsp");
        }
        else{
            User user = new User();
            user.setUsername(username);
            user.setPassword(pass);
            user.setName(name);
            user.setEmail(email);
            userDao.insert(user);
//            out.println("<script type=\"text/javascript\">");
//            out.println("alert('Create account successful.');");
//            out.println("</script>");
            response.sendRedirect("login.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
}
