package cn.web.dao;

import cn.web.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 操作用户的dao
 */
public interface UserDao {
    /**
     * 查询所有用户信息
     * @return 用户集合
     */
    public List<User> findAll();

    /**
     * 登陆
     * @param username
     * @param password
     * @return 包含所有用户信息的对象
     */
    public User login(String username,String password);

    /**
     * 添加用户
     * @param user
     */
    void add(User user);

    /**
     * 根据id删除用户
     * @param id
     */
    void delete(int id);

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    User findUserById(String id);

    /**
     * 更新用户信息
     * @param user
     */
    void update(User user);

    /**
     * 查找总记录数
     * @return
     * @param condition
     */
    int totalCount(Map<String, String[]> condition);

    /**
     * 分页查询
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
