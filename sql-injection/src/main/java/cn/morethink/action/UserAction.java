package cn.morethink.action;

import cn.morethink.dao.UserDaoImpl;
import cn.morethink.entity.User;
import cn.morethink.util.Result;
import cn.morethink.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 李文浩
 * @date 2018/1/3
 */

@RestController
@RequestMapping("/user")
public class UserAction {

    @Autowired
    UserDaoImpl userDao;

    @PostMapping("/loginWithoutSQLInjection")
    public Result loginWithoutSQLInjection(User user, HttpSession session, HttpServletResponse response) {
        Map<String, Object> map = userDao.loginWithoutSQLInjection(user);
        if (map.get("user") != null) {
            return ResultUtil.successResult(map);
        }
        return ResultUtil.errorResult("", map);
    }

    @PostMapping("/loginWithSQLInjection")
    public Result loginWithSQLInjection(User user, HttpSession session, HttpServletResponse response) {
        Map<String, Object> map = userDao.loginWithSQLInjection(user);
        if (map.get("user") != null) {
            return ResultUtil.successResult(map);
        }
        return ResultUtil.errorResult("", map);
    }

    @RequestMapping("/test")
    public Result test(User user,String us) {
        System.out.println(us);
        return ResultUtil.errorResult("", user);
    }
}
