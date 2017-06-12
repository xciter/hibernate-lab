package com.authorization.dao;

import com.authorization.entities.User;

public interface UserDao {

    void addUser(User user);

    boolean isUserValid(User user);

    boolean isUserExist(User user);

    void updateUser(User user);

    void getUserInfo(User user);

}
