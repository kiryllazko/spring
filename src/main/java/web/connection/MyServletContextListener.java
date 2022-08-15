package web.connection;

import com.lirik.model.Product;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MyServletContextListener implements ServletContextListener {

    Connection connection = null;

    public void contextInitialized(ServletContextEvent event) {
        try {
            // Использование объекта конфигурации базы данных для инициализации класса инструмента подключения к базе данных
            DBConnConfig dbConfig = getDBConnConfig(event);
            if (dbConfig != null) {
                DBMangerUtil.initDBMangerUtil(dbConfig);
            }

            // Создать соединение с базой данных
            connection = DBMangerUtil.getConnection();

            // Сохраняем соединение в контексте ServletContext
            event.getServletContext().setAttribute("dbconn", connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent event) {
        try {
            // Закрыть соединение с базой данных
            DBMangerUtil.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private DBConnConfig getDBConnConfig(ServletContextEvent event) {

        // Используем для получения параметров инициализации контекста веб-приложения
        ServletContext ctx = event.getServletContext();
        String driver = ctx.getInitParameter("driver");
        String url = ctx.getInitParameter("url");
        String username = ctx.getInitParameter("username");
        String password = ctx.getInitParameter("password");

        DBConnConfig dbConfig = null;
        dbConfig = new DBConnConfig(driver, url, username, password);
        return dbConfig;
    }
}
