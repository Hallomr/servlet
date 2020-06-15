package com.example.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 注解@ServletComponentScan自动扫描对应包下面的Servlet类，默认是启动类所在的包
 *
 * */
@SpringBootApplication
@ServletComponentScan
public class ServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServletApplication.class, args);
    }

    /*@Bean
    public ServletRegistrationBean getServletRegistrationBean(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new MyHttpServlet());
        bean.addUrlMappings("/my/http/servlet");
        return bean;
    }*/
}
