package com.wsw.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author loriyuhv
 * @date 2025/8/16
 * @description User
 */
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    private static final String MOCK_USER = "admin";
    private static final String MOCK_PWD  = "123456";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决中文乱码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Map<String, Object> json = new HashMap<>();

        if (MOCK_USER.equals(username) && MOCK_PWD.equals(password)) {
            // 登录成功
            String token = java.util.UUID.randomUUID().toString();
            req.getSession().setAttribute("token", token); // 服务器端会话
            json.put("success", true);
            json.put("msg", "登录成功");
            json.put("token", token);
            json.put("user", Map.of("username", username, "email", username + "@demo.com"));
        } else {
            json.put("success", false);
            json.put("msg", "用户名或密码错误");
        }

        new ObjectMapper().writeValue(resp.getWriter(), json);
    }
}
