package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static config.ConnectorConfig.closeConnect;
import static config.ConnectorConfig.openConnect;

public class Menu {
    public static void test() throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        boolean isTrue = true;
        while (isTrue) {
            switch (scanner.next()) {
                case "0" : {
                    isTrue = false;
                    break;
                }
                case "1":{
                    getInfoFromUser();
                    break;
                }
                case "2":{
                    getInfoFromMed();
                    break;
                }
                case "3": {
                    getInfoFromUserMed();
                    break;
                }
                default:{
                    System.out.println("Неверное значение: ");
                }
            }
        }
    }

    private static void getInfoFromUserMed() throws SQLException, ClassNotFoundException {
        Connection connection = openConnect();
        try{
            Statement statement = connection.createStatement();
            String query = "SELECT * from USER join medical_centre on user.id=user_id";
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();

            User user = getInfoFromUser1(resultSet);
            System.out.println(user);

            Medical_center medical_center = getInfoFromMed1(resultSet);
            System.out.println(medical_center);

            resultSet.close();
            statement.close();
            closeConnect(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private static void getInfoFromUser() throws SQLException, ClassNotFoundException {
        Connection connection = openConnect();
        try{
            Statement statement = connection.createStatement();
            String query = "SELECT * from USER";
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();

            User user = getInfoFromUser1(resultSet);
            System.out.println(user);

            resultSet.close();
            statement.close();
            closeConnect(connection);
            //get INFO
//            int id = resultSet.getInt("id");
//            String name = resultSet.getString("name");
//            String lastName = resultSet.getString("lastName");
//            String pass = resultSet.getString("pass");
//
//            //set info
//            User user = new User();
//            user.setId(id);
//            user.setName(name);
//            user.setLastname(lastName);
//            user.setPass(pass);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getInfoFromMed() throws SQLException, ClassNotFoundException {
        Connection connection = openConnect();
        try{
            Statement statement = connection.createStatement();
            String query = "SELECT * from  medical_centre";
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.next();
            Medical_center medical_center = getInfoFromMed1(resultSet);
            System.out.println(medical_center);

            resultSet.close();
            statement.close();
            closeConnect(connection);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private static User getInfoFromUser1(ResultSet resultSet) throws SQLException, ClassNotFoundException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String lastName = resultSet.getString("lastName");
        String pass = resultSet.getString("pass");

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setLastname(lastName);
        user.setPass(pass);
        return user;
    }

    private static Medical_center getInfoFromMed1(ResultSet resultSet) throws SQLException, ClassNotFoundException {
        int id = resultSet.getInt("id");
        String Centre_name = resultSet.getString("Centre_name");
        int  user_id = resultSet.getInt( "user_id");

        Medical_center medical_center = new Medical_center();
        medical_center.setId(id);
        medical_center.setCentreName(Centre_name);
        medical_center.setUser_id(user_id);
        return medical_center;
    }



}