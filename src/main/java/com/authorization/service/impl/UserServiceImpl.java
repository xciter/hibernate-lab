package com.authorization.service.impl;

import com.authorization.dao.UserDao;
import com.authorization.dao.impl.UserDaoImpl;
import com.authorization.entities.User;
import com.authorization.service.UserService;

public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    public boolean isUserValid(User user) {
        return userDao.isUserValid(user);
    }

    public void createUser(User user) {
        userDao.addUser(user);
    }
}
