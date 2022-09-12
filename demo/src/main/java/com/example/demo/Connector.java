package com.example.demo;

import org.springframework.stereotype.Service;

import java.sql.*;
@Service
public class Connector {
    private static String url = "jdbc:mysql://localhost:3306/homework_relationship";
    private static String username = "root";
    private static String password = "14072018";

    public static void connect ()  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from transactional_history");

            while ((resultSet.next())){
                System.out.println(resultSet.getString(4));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {

        } catch (ClassNotFoundException e) {

        }

    }
}
