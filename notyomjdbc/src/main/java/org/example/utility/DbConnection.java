package org.example.utility;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    Connection con=null;
    String url="jdbc:postgresql://localhost:5432/denemeNaime";
    String username="postgres";
    String password="root";

    public Connection getCon(){
        try {
            Driver.class.forName("org.postgresql.Driver");
            con= DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver bağlantısında hata aldık");
            throw new RuntimeException(e);
        }catch (SQLException sql){
            System.out.println("Sql hatası aldık");
            sql.printStackTrace();
        }
        return con;
    }

    public boolean closeConnection(Connection connection){
        try {
            connection.close();
        } catch (SQLException sql) {
           sql.printStackTrace();
        }
        return false;
    }


}
