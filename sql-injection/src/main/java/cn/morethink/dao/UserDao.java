package cn.morethink.dao;

import cn.morethink.entity.User;

import java.util.Map;

/**
 * @author 李文浩
 * @date 2018/1/3
 */


public interface UserDao {

    Map<String, Object> loginWithoutSQLInjection(User user);

    Map<String, Object> loginWithSQLInjection(User user);
}
