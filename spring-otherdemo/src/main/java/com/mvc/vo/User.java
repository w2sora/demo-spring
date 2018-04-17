package com.mvc.vo;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 6327133471290321218L;

    private String userId;
    private String name;
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
