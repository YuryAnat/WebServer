package connections;

import models.User;
import org.hibernate.cfg.Configuration;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
    private Properties properties = new Properties();
    private static DBHelper dbHelper;

    private DBHelper(){
        try {
            properties.load(DBHelper.class.getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DBHelper getInstance(){
        if (dbHelper == null){
            dbHelper = new DBHelper();
            return dbHelper;
        }else {
            return dbHelper;
        }
    }

    private String getUrlConnection(){
        return properties.getProperty("url") + properties.getProperty("host")
                + ":" + properties.getProperty("port") + "/" + properties.getProperty("base");
    }

    public Configuration getConfiguration(){
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.dialect", properties.getProperty("dialect"));
        configuration.setProperty("hibernate.connection.driver_class", properties.getProperty("driver"));
        configuration.setProperty("hibernate.connection.url", getUrlConnection());
        configuration.setProperty("hibernate.connection.username", properties.getProperty("user"));
        configuration.setProperty("hibernate.connection.password", properties.getProperty("password"));
        configuration.setProperty("hibernate.show_sql", properties.getProperty("show_sql"));
        configuration.setProperty("hibernate.hbm2ddl.auto", properties.getProperty("hbm2ddl.auto"));
        configuration.setProperty("hibernate.hbm2ddl.auto", properties.getProperty("hbm2ddl.auto"));
        configuration.addAnnotatedClass(User.class);
        return configuration;
    }

    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(properties.getProperty("driver"));
            connection = DriverManager.getConnection(getUrlConnection(),properties.getProperty("name"),properties.getProperty("password"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
