package filter;

import model.entity.User;
import util.SecurityUtils;
import util.AppUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class SecurityFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String servletPath = request.getServletPath();

        //get user info from session(after Login)
        User loginedUser = AppUtils.getLoginedUser(request.getSession());


//        HttpServletRequest wrapRequest = request;

        if(SecurityUtils.isSecurityPage(request)){
            if(loginedUser == null){
                response.sendRedirect("/login");
                return;
            }

            boolean hasPermission = SecurityUtils.hasPermission(request);
            if(!hasPermission){
                response.sendRedirect("403.jsp");
                return;
            }
        }


        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
