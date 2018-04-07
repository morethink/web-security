package cn.morethink.action;

import cn.morethink.dao.PostDao;
import cn.morethink.util.Result;
import cn.morethink.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李文浩
 * @date 2018/1/3
 */

@RestController
@RequestMapping("/post")
public class PostAction {

    @Autowired
    PostDao postDao;

    @GetMapping("/{id}")
    public Result getPost(@PathVariable int id) {
        return ResultUtil.successResult(postDao.getPost(id));
    }
}
