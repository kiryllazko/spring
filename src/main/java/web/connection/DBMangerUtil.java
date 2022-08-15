package web.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBMangerUtil {
    public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/ccd";
    public static String username = "root";
    public static String password = "011016";

    public static Connection conn = null;

    // Инициализируем переменные экземпляра DBMangerUtil
    public static void initDBMangerUtil(DBConnConfig dbConfig) {
        DBMangerUtil.driver = dbConfig.getDriver();
        DBMangerUtil.url = dbConfig.getUrl();
        DBMangerUtil.username = dbConfig.getUsername();
        DBMangerUtil.password = dbConfig.getPassword();
    }

    // Получить соединение
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    // закрываем соединение
    public static void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

}
