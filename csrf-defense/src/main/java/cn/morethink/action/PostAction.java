package cn.morethink.action;

import cn.morethink.service.PostService;
import cn.morethink.util.Result;
import cn.morethink.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    private PostService postService;

    @DeleteMapping("/{id}")
    public Result deletePost(@PathVariable int id) {
        postService.deletePost(id);
        return ResultUtil.SUCCESS_RESULT;
    }
}
