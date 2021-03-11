package cn.web.service;

import cn.web.domain.PageBean;
import cn.web.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的业务接口
 */
public interface UserService {


    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(int id);

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
     * 根据id批量删除用户
     * @param uids
     */
    void delSelectUser(String[] uids);

    /**
     * 分页条件查询对象
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<User> findUserByPage(int currentPage, int rows, Map<String, String[]> condition);

    User login(User loginUser);
}
