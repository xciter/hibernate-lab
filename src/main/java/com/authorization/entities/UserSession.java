package com.authorization.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table (name = "User_session")
public class UserSession {
    @Id
    @Column(name = "session_id", unique = true)
    private int sessionId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "created_on")
    private Timestamp createdOn;

    @Column(name = "expires_on")
    private Timestamp expiresOn;

    @Column(name = "is_valid")
    private boolean isValid;

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Timestamp getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(Timestamp expiresOn) {
        this.expiresOn = expiresOn;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
