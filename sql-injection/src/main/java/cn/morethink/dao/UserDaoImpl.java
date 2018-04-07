package cn.morethink.dao;

import cn.morethink.entity.User;
import cn.morethink.util.DBUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 李文浩
 * @date 2018/4/7
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public Map<String, Object> loginWithoutSQLInjection(User user) {
        User u = null;
        Map<String, Object> map = new HashMap<>();

        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            System.out.println(ps);
            System.out.println(ps.toString().split(":")[1].trim());
            map.put("sql", ps.toString().split(":")[1].trim());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new User();
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("user", u);
        return map;
    }

    @Override
    public Map<String, Object> loginWithSQLInjection(User user) {
        Map<String, Object> map = new HashMap<>();

        User u = null;
        String sql = "SELECT * FROM user WHERE username = '" + user.getUsername() +
                "' AND password = '" + user.getPassword() + "'";
        try {
            Connection conn = DBUtil.getConnection();
            Statement statement = conn.createStatement();
            System.out.println(sql);
            map.put("sql", sql);
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                u = new User();
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("user", u);

        return map;
    }
}
