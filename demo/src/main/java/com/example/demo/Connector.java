package com.example.demo;

import config.ConnectorConfig;
import model.User;
import org.springframework.stereotype.Service;

import java.sql.*;

import static config.ConnectorConfig.closeConnect;
import static config.ConnectorConfig.openConnect;

@Service
//public class Connector {
//    private static String url = "jdbc:mysql://localhost:3306/les";
//    private static String username = "root";
//    private static String password = "14072018";

//    public static void connect ()  {
//        try {
//
//            Connection connection = openConnect();

//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection connection = DriverManager.getConnection(ConnectorConfig.url, ConnectorConfig.username, ConnectorConfig.password);

//            Statement statement = connection.createStatement();
//            String update = "Insert into User (id, name, lastName, pass) values (1,'test', 'testL', '12345')";
//            String query = "Select * from user";
//            ResultSet resultSet = statement.executeQuery(query);

//            resultSet.next();
//
//            int id = resultSet.getInt("id");
//            String name = resultSet.getString("name");
//            String lastName = resultSet.getString("lastName");
//            String pass = resultSet.getString("pass");

//            User user = new User();
//            user.setId(id);
//            user.setName(name);
//            user.setLastname(lastName);
//            user.setPass(pass);
//            User object = resultSet.getObject(0, User.class);
//            System.out.println(user);
//            ResultSet resultSet = statement.executeQuery(update);
//            statement.executeUpdate(update);
//            while ((resultSet.next())){
//                System.out.println(resultSet.getString(5));
//            }
//            resultSet.close();
//            statement.close();
//            connection.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//
//        } catch (ClassNotFoundException e) {
//
//        }

//    }


//}

public class Connector {

    public static void connect ()  {
        try {
            Connection connection = openConnect();
            Statement statement = connection.createStatement();
            String query = "SELECT * from USER";
            ResultSet resultSet = statement.executeQuery(query);
//            User object = resultSet.getObject(0, User.class);
            resultSet.next();
            //get INFO
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String lastName = resultSet.getString("lastName");
            String pass = resultSet.getString("pass");

            //set info
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setLastname(lastName);
            user.setPass(pass);


            System.out.println(user);

            resultSet.close();
            statement.close();
            closeConnect(connection);
        } catch (SQLException e) {

        } catch (ClassNotFoundException ignored) {
        }
    }




}



