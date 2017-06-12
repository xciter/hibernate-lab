package com.authorization.service;

import com.authorization.entities.User;

public interface UserService {

    boolean isUserValid(User user);

    boolean isUserExist(User user);

    void createUser(User user);

    void updateUser(User user);

    void getUserInfo(User user);
}
