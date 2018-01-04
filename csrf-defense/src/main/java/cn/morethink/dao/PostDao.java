package cn.morethink.dao;

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
    int deletePost(int id);
}
