package cn.web.service.impl;

import cn.web.dao.UserDao;
import cn.web.dao.impl.UserDaoImpl;
import cn.web.domain.PageBean;
import cn.web.domain.User;
import cn.web.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();


    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void addUser(User user) {
        userDao.add(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.delete(id);
    }

    @Override
    public User findUserById(String id) {
        return userDao.findUserById(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delSelectUser(String[] uids) {
        if(uids != null && uids.length>0){
            for (String uid : uids) {
                userDao.delete(Integer.parseInt(uid));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(int currentPage, int rows, Map<String, String[]> condition) {
        //1.创建空的PageBean对象
        PageBean<User> userPageBean = new PageBean<>();

        if(currentPage <= 0){
            currentPage = 1;
        }

        //2.查询总记录数
        int totalCount = userDao.totalCount(condition);
        userPageBean.setTotalCount(totalCount);



        int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
        userPageBean.setTotalPage(totalPage);

        if(currentPage > totalPage){
            currentPage = totalPage;
        }

        if(currentPage <= 0){
            currentPage = 1;
        }

        //3.设置当前属性，rows属性
        userPageBean.setCurrentPage(currentPage);
        userPageBean.setRows(rows);

        //4.每页的list集合
        int start = (currentPage - 1)*rows;
        List<User> list = userDao.findByPage(start,rows,condition);
        userPageBean.setList(list);


        return userPageBean;
    }

    @Override
    public User login(User loginUser) {
        return userDao.login(loginUser.getUsername(),loginUser.getPassword());
    }


}
