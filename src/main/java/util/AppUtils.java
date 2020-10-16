package util;

import model.entity.User;

import javax.servlet.http.HttpSession;

public class AppUtils {
    public static void storeLoginedUser(HttpSession session, User user){

        session.setAttribute("user", user);
    }

    public static User getLoginedUser(HttpSession session){
        return (User) session.getAttribute("user");
    }
}
