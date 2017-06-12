package com.authorization.service;

import com.authorization.entities.User;

public interface UserService {

    boolean isUserValid(User user);

    void createUser(User user);
}
