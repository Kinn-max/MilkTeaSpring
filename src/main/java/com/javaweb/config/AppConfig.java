package com.javaweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

@Configuration
public class AppConfig implements ServletContextAware {

    @Autowired
    private ServletContext servletContext;

    private String imgDir;

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @PostConstruct
    public void init() {
        imgDir = servletContext.getInitParameter("img");
    }

    public String getImgDir() {
        return imgDir;
    }
}

