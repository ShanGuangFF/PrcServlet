package cn.web.dao.impl;

import cn.web.dao.UserDao;
import cn.web.domain.User;
import cn.web.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public  List<User> findAll() {
        //操作数据库
        //1.编写sql
        String sql = "select * from user";
        List<User> userList = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    @Override
    public User login(String username ,String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User loginUser = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return loginUser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
