package cn.morethink.service;

import cn.morethink.dao.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 李文浩
 * @date 2018/1/3
 */

@Service
public class PostService {

    @Autowired
    private PostDao postDao;

    public void deletePost(int id) {
        postDao.deletePost(id);
    }
}
