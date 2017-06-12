package com.authorization.dao;

import com.authorization.entities.User;
import com.authorization.entities.UserSession;

public interface SessionDao {

    UserSession generateSession(User user);

    boolean isSessionValid(UserSession session);

    void invalidateSession(UserSession session);
}
