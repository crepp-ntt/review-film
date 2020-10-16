package util;

import constant.CONSTANT;
import model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class SecurityUtils {

    public static boolean isSecurityPage(HttpServletRequest request){
        String urlPattern = request.getServletPath();
        return Arrays.asList(CONSTANT.USER_URL).contains(urlPattern) || Arrays.asList(CONSTANT.ADMIN_URL).contains(urlPattern);
    }

    public static boolean hasPermission(HttpServletRequest request){
        String urlPattern = request.getServletPath();
        User user = AppUtils.getLoginedUser(request.getSession());
        if(user.getRole() == 0)
            return true;
        else return user.getRole() == 1 && Arrays.asList(CONSTANT.USER_URL).contains(urlPattern);
    }
}
