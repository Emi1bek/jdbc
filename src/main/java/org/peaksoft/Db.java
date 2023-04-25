package org.peaksoft;

import java.io.IOException;
import java.sql.*;

public class Db {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "1234";

    public static Connection connection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println("Успешно подключились");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }


    public static void createTable(){
        String SQL = "CREATE TABLE studentz("+
                "id SERIAL PRIMARY KEY,"+
                "name VARCHAR(50) NOT NULL,"+
                "age INTEGER);";
        try(Connection connection = Db.connection();
            Statement statement = connection.createStatement() ){
            statement.executeUpdate(SQL);


        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static  int getCount(){
        String SQL = "SELECT count(*) FROM studentz";
        int count = 0;
        try(Connection connection = Db.connection();
        Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(SQL);
            resultSet.next();
            count=resultSet.getInt(1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return count;
    }

    public static void addStudent(String name, int age){
        String SQL = "INSERT INTO studentz(name,age)"+
                "VALUES(?,?);";
        try(Connection connection = Db.connection();
            PreparedStatement pr = connection.prepareStatement(SQL)){
            pr.setString(1,name);
            pr.setInt(2,age);
            pr.executeUpdate();
            }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
