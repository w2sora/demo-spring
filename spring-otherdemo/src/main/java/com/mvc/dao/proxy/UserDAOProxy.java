package com.mvc.dao.proxy;

import com.mvc.dao.IUserDAO;
import com.mvc.dao.impl.UserDAOImpl;
import com.mvc.dbc.DatabaseConnection;
import com.mvc.vo.User;

public class UserDAOProxy implements IUserDAO {
    private DatabaseConnection dbc = null;
    private IUserDAO dao = null;

    public UserDAOProxy() {
        try {
            this.dbc = new DatabaseConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.dao = new UserDAOImpl(this.dbc.getConnection());
    }

    @Override
    public boolean findLogin(User user) throws Exception {
        boolean flag = false;

        try {
            flag = this.dao.findLogin(user);
        } finally {
            this.dbc.close();
        }

        return flag;
    }
}
