package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private static Connection connection;

    private JdbcConnection(){}

    public static Connection getConnection(){
        if (connection == null){
            try {
                Class.forName("org.postgresql.Driver");
                DBConfig conf = new DBConfig();
                String url = "jdbc:postgresql://" + conf.getHost() + ":" + conf.getPort() + "/" + conf.getBase();
                connection = DriverManager.getConnection(url,conf.getUser(),conf.getPass());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
