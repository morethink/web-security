package cn.morethink.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 李文浩
 * @date 2018/1/3
 */

@Order(1)
@WebFilter(filterName = "userFilter", urlPatterns = {"/deletePost.html", "/post/*"})
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            String method = request.getMethod();
            System.out.println(method);
            if (method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("DELETE")
                    || method.equalsIgnoreCase("PUT")) {
                String csrf_token = request.getParameter("csrf_token");
                System.out.println(csrf_token);
                Cookie[] cookies = request.getCookies();
                if (cookies != null && cookies.length > 0) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("csrf_token")) {
                            if (Integer.valueOf(csrf_token) == cookie.getValue().hashCode()) {
                                chain.doFilter(servletRequest, servletResponse);
                            } else {
                                response.sendError(405,"xixi");
                            }
                        }
                    }
                }
            } else {
                chain.doFilter(servletRequest, servletResponse);
            }
        } else {
            response.sendRedirect("/login.html");
        }

    }

    @Override
    public void destroy() {

    }
}
