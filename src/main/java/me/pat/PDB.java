package me.pat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PDB {

    private final String DB_USER = "root";
    private final String DB_PASS = "";
    private final String DB_URL = "jdbc:mysql://localhost/test";

     static Connection conn;
     static Statement statement;

    public PDB(){
        try{
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            statement = conn.createStatement();
            System.out.println("[DEBUG] Connected to database.");
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    // Create a password
    public static Password createPassword(String username, String password, String name){
        try {
            ResultSet rs = statement.executeQuery("SELECT COUNT(*) AS total FROM `passwords`");
            int count = 0;
            while (rs.next()) {
                count = rs.getInt("total");
            }
            String query = "INSERT INTO passwords (id, name, username, password) VALUES ('" +
                    count + "', '" +
                    name + "', '" +
                    username + "', '" +
                    password + "');";
            System.out.println(query);
            statement.executeUpdate(query);

            System.out.println("Password \"" + name + "\" has been created.");
            return new Password(count, username, password, name);

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    //Find a password
    public static List<Password> findPassword(String term){
        List<Password> list = new ArrayList<Password>();
        try{
            String query = "SELECT * FROM passwords WHERE name = '" + term + "' " +
                    "OR username = '" + term + "';";
            boolean results = statement.execute(query);
            int rsCount = 0;
            do {
                if(results){
                    ResultSet rs = statement.getResultSet();
                    rsCount++;

                    while(rs.next()){
                        if(rs.wasNull()){
                            return null;
                        } else {
                            int id = rs.getInt("id");
                            String name = rs.getString("name");
                            String username = rs.getString("username");
                            String password = rs.getString("password");
                            list.add(new Password(id, username, password, name));
                        }
                    }

                    results = statement.getMoreResults();

                }
            } while(results);

            return list;

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
