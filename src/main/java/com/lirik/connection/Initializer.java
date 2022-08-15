package com.lirik.connection;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Component
public class Initializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        ProductDAOImpl productDAO = new ProductDAOImpl();
        servletContext.setAttribute("productDAO", productDAO);
        System.out.println("Started");
    }
}
