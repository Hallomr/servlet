package com.example.servlet.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

/**
 * httpservlet service方法调用doget/dopost/doput/dodelete
 * */
@WebServlet(urlPatterns = "/my/http/servlet")
public class MyHttpServlet extends HttpServlet {
    public MyHttpServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 获取servletContext对象的三种方式
         * */
        ServletContext s1 = getServletContext();
        ServletContext s2 = getServletConfig().getServletContext();
        ServletContext s3 = req.getServletContext();
        System.out.println(s1.equals(s2));

        /*
        * servletcontext作为域对象存值取值
        * */
        Object o = "value";
        s1.setAttribute("key",o);
        System.out.println("get请求--------");

        /*
        * servletcontext获取项目路径
        * */
        String realPath = s3.getRealPath("");
        System.out.println(realPath+"----------");

        InputStream inputStream = this.getClass().getResourceAsStream("/static/mm.jpg");
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(bytes))!= -1){
            outputStream.write(bytes,0,len);
        }
        outputStream.close();
        inputStream.close();

        //request 获取请求参数
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            System.out.println("key:"+entry.getKey()+"------value:"+entry.getValue());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post请求--------");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
