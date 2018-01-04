package cn.morethink.action;

import cn.morethink.entity.User;
import cn.morethink.util.Result;
import cn.morethink.util.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author 李文浩
 * @date 2018/1/3
 */

@RestController
@RequestMapping("/user")
public class UserAction {

    @PostMapping("/login")
    public Result login(User user, HttpSession session, HttpServletResponse response) {
        if ("admin".equals(user.getUsername())
                && "admin".equals(user.getPassword())) {
            session.setAttribute("user", user);

            String csrf_token = UUID.randomUUID().toString();
            System.out.println(csrf_token);
            Cookie csrf_Cookie = new Cookie("csrf_token", csrf_token);
            csrf_Cookie.setPath("/");
            csrf_Cookie.setMaxAge(10 * 24 * 60 * 60);
            response.addCookie(csrf_Cookie);

            return ResultUtil.SUCCESS_RESULT;
        }
        return ResultUtil.FAIL_RESULT;
    }

    @PostMapping("/logout")
    public Result logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("csrf_token")) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
        return ResultUtil.SUCCESS_RESULT;
    }

    public static void main(String[] args) {
        System.out.println("djdjdkdkfdka".hashCode());
    }
}
