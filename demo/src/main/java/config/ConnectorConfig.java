package config;

import com.example.demo.Connector;
import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorConfig {
    public static final String url = "jdbc:mysql://localhost:3306/les";
    public static final String username = "root";
    public static final String password = "14072018";

    public static Connection openConnect() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }
    public static void closeConnect(Connection connection) throws SQLException {
        connection.close();
    }
    public static User prepareUserInfo(Integer id, String name, String lastName, String pass){
        return new User(id, name, lastName, pass);
    }
}
