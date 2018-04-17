package com.mvc.dao.impl;

import com.mvc.dao.IUserDAO;
import com.mvc.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl implements IUserDAO {
    private Connection conn;
    private PreparedStatement ps = null;

    public UserDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean findLogin(User user) throws Exception {
        boolean flag = false;

        try {
            String sql = "SELECT name FROM user WHERE userid = ? AND password = ?";
            this.ps = this.conn.prepareStatement(sql);
            this.ps.setString(1, user.getUserId());
            this.ps.setString(2, user.getPassword());

            ResultSet rs = this.ps.executeQuery();
            if (rs.next()) {
                user.setName(rs.getString(1));
                flag = true;
            }
        } finally {
            if (this.ps != null) {
                this.ps.close();
            }
        }

        return flag;
    }
}
