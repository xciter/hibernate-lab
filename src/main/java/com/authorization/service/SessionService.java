package com.authorization.service;

import com.authorization.entities.User;
import com.authorization.entities.UserSession;

public interface SessionService {

    void generateSessionId(User user);

    boolean isSessionValid(UserSession session);
}
