package ua.com.mysqlcmd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseConnect {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("want to connect to the database enter the user database name and password\n__________");
        Scanner scan = new Scanner(System.in);
        System.out.println("databaseName:");
        String database = scan.next();
        System.out.println("user:");
        String user = scan.next();
        System.out.println("password:");
        String password = scan.next();

        Connection connection = getConnection(database, user, password);
        connection.close();
    }

    private static Connection getConnection(String database, String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, user, password);
        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");

        }
        return connection;
    }
}