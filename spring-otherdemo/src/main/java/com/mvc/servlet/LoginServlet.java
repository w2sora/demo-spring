package com.mvc.servlet;

import com.mvc.factory.DAOFactory;
import com.mvc.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String path = "login.jsp";
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        List<String> info = new ArrayList<>();
        if (isEmpty(userId)) {
            info.add("用户名不能为空！");
        }
        if (isEmpty(password)) {
            info.add("密码不能为空！");
        }

        if (info.size() == 0) {
            User user = new User();
            user.setUserId(userId);
            user.setPassword(password);

            try {
                if (DAOFactory.getIUserDAOInstance().findLogin(user)) {
                    info.add("用户登录成功，欢迎 " + user.getName() + " 光临！");
                } else {
                    info.add("用户登录失败，错误的用户名和密码！");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        req.setAttribute("info", info);
        req.getRequestDispatcher(path).forward(req, res);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.doGet(req, res);
    }

    private boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }
}
