package cn.web.dao;

import cn.web.domain.User;

import java.util.List;

/**
 * 操作用户的dao
 */
public interface UserDao {
    public List<User> findAll();

    public User login(String username, String password);
}
