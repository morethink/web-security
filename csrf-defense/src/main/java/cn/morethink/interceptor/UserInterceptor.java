package cn.morethink.interceptor;

import cn.morethink.util.JsonUtil;
import cn.morethink.util.Result;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author 李文浩
 * @date 2018/1/4
 */
public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        System.out.println(method);
        if (method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("DELETE")
                || method.equalsIgnoreCase("PUT")) {
            String csrf_token = request.getParameter("csrf_token");
            System.out.println(csrf_token + "1222222222222222222222222222222222222222222222");
            Cookie[] cookies = request.getCookies();
            if (cookies != null && cookies.length > 0 && csrf_token != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("csrf_token")) {
                        if (Integer.valueOf(csrf_token) == cookie.getValue().hashCode()) {
                            return true;
                        }
                    }
                }
            }
        }
        Result result = new Result("403", "你还想攻击我??????????", "");
        PrintWriter out = response.getWriter();
        out.write(JsonUtil.toJson(result));
        out.close();
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
