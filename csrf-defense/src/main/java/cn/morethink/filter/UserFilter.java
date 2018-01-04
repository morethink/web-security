package cn.morethink.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
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
            chain.doFilter(request, response);
        } else {
            response.sendRedirect("/login.html");
        }

    }

    @Override
    public void destroy() {

    }
}
