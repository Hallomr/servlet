package com.example.servlet.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
/**
 * 通过@WebServlet注解注册的方式来注册Servlet
 * */
@WebServlet(urlPatterns = "/my/servlet")
public class MyServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("servlet初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        ServletContext servletContext = servletRequest.getServletContext();
        Object key = servletContext.getAttribute("key");
        System.out.println("--------------"+key);
        System.out.println("service被调用");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy........");
    }
}
