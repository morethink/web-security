package cn.morethink.dao;

import cn.morethink.entity.Post;
import org.springframework.stereotype.Repository;

/**
 * @author 李文浩
 * @date 2018/1/3
 */

@Repository
public interface PostDao {

    /**
     *
     * @param id
     * @return
     */
    Post getPost(int id);
}
