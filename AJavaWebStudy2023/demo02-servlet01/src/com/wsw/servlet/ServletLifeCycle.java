package com.wsw.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author loriyuhv
 * @date 2025/8/17
 * @description Servlet生命周期
 * 1. 实例化 ServletLifeCycle的对象是谁实例化的？ 答：Tomcat
 *  构造器：第一次请求执行
 * 2. 初始化 谁定义的？ Servlet的接口定义的。
 *  init()：构造器执行完毕执行
 * 3. 接收请求，处理请求服务方法
 *  service()：每次请求执行
 * 4. 销毁
 *  destroy()：关闭服务的时候执行一次
 *
 * 总结：Servlet在Tomcat中是单例的
 * Servlet的成员变量在多个线程栈之中是共享的
 * 强烈不支持在service方法中修改成员变量，在并发请求时会引发线程安全问题
 *
 * default-servlet
 */

// loadOnStartup：默认值时-1，含义是tomcat启动时不会实例化该servlet
// 其他正整数：1~N，数值越低，权重越高。含义是Tomcat在启动时，实例化该*Servlet的顺序
// 如果序号冲突了，Tomcat会自动协调启动顺序
// 不建议直接写1，因为除了会执行项目自身web.xml文件，还会执行Tomcat的web.xml文件（公共），所以不建议使用Tomcat配置过的数值
@WebServlet(value = "/servletLifeCycle", loadOnStartup = 100)
public class ServletLifeCycle extends HttpServlet {
    public ServletLifeCycle() {
        System.out.println("ServletLifeCycle's constructor has been executed...");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("ServletLifeCycle init() has been executed...");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletLifeCycle service has been executed...");
    }

    @Override
    public void destroy() {
        System.out.println("ServletLifeCycle destroy() has been executed...");
    }
}
