package cn.web.service.impl;

import cn.web.dao.UserDao;
import cn.web.dao.impl.UserDaoImpl;
import cn.web.domain.User;
import cn.web.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();


    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User login(User loginUser) {
        return userDao.login(loginUser.getUsername(),loginUser.getPassword());
    }
}
