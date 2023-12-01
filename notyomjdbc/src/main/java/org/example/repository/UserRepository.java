package org.example.repository;

import org.example.entity.Users;
import org.example.utility.DbConnection;
import org.example.utility.Singleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository{
    DbConnection dbConnection;
    public UserRepository(){
        dbConnection=Singleton.getDbConnection();
    }
    Connection con = null;
    public boolean save(Users users) {
        con=dbConnection.getCon();
        String insertUser =
                "insert into users(name,lastname,email,password) values(?,?,?,?)";
        try {

            PreparedStatement pr=con.prepareCall(insertUser);
            pr.setString(1, users.getName());
            pr.setString(2, users.getLastname());
            pr.setString(3, users.getEmail());
            pr.setString(4, users.getPassword());
            pr.executeUpdate();
            return  true;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConnection.closeConnection(con);
        }return false;
    }
    public Users isExist(String email, String password) {
        con = dbConnection.getCon();
        String sqlselect = "select * from users where email='" + email + "'AND password='" + password + "'";
        try {
            PreparedStatement ps = con.prepareCall(sqlselect);
            ResultSet resultSet = ps.executeQuery();
            Users Users = new Users();

            while (resultSet.next()) {

                Users.setId(resultSet.getInt("id"));
                Users.setEmail(resultSet.getString("email"));
                Users.setName(resultSet.getString("name"));
                Users.setLastname(resultSet.getString("lastname"));
                Users.setPassword(resultSet.getString("password"));
            }
            return Users;
        } catch (SQLException s) {
            s.printStackTrace();
            System.out.println("Kontrol yapılamadı");
        } finally {
            dbConnection.closeConnection(con);
        }
        return null;

    }
    public boolean updateMail(Users Users, String updateMail){
        // connetion açtık
        Users usersIsExist =isExist(Users.getEmail(), Users.getPassword());
        String mailUpdate = "update users set email = '"+updateMail+"'  where id='"+ usersIsExist.getId()+" '";
        con = dbConnection.getCon();
        try {
            PreparedStatement ps = con.prepareCall(mailUpdate);
            ps.executeUpdate();
            System.err.println("Kullanıcı mail adresi güncellendi= "+ Users.getEmail());

            return true;
        }
        catch (SQLException s){
            s.printStackTrace();
            System.out.println("E mail güncellenmedi");
        }
        finally {
            dbConnection.closeConnection(con);
        }
        return false;
    }


    public boolean updateName(Users users){
        con = dbConnection.getCon(); // connetion açtık
        String nameUpdate =  "UPDATE users SET name = '"+ users.getName()+"'  WHERE email ='"+ users.getEmail()+"'";
        try {
            PreparedStatement ps = con.prepareCall(nameUpdate);
            ps.executeUpdate();
            System.out.println("Kullanıcı ismi adresi güncellendi= "+ users.getName());
            return true;
        }
        catch (SQLException s){
            s.printStackTrace();
            System.out.println("İsim güncellenmedi");
        }
        finally {
            dbConnection.closeConnection(con);
        }
        return false;

    }

    public boolean updateSurname(Users Users){
        con = dbConnection.getCon(); // connetion açtık
        String lastnameUpdate =  "UPDATE users SET lastname = ? where email = ? ";
        try {
            PreparedStatement ps = con.prepareCall(lastnameUpdate);
            ps.setString(1, Users.getLastname());
            ps.setString(2, Users.getEmail());

            ps.executeUpdate();
            System.out.println("Kullanıcı soyismi güncellendi= "+ Users.getLastname());
            return true;
        }
        catch (SQLException s){
            s.printStackTrace();
            System.out.println("Soyisim güncellenmedi");
        }
        finally {
            dbConnection.closeConnection(con);
        }
        return false;

    }
    public boolean updatePassword(Users users){
        con = dbConnection.getCon(); // connetion açtık
        String passwordUpdate =  "UPDATE users SET password = '"+ users.getPassword()+"'  WHERE email ='"+ users.getEmail()+"'";
        try {
            PreparedStatement ps = con.prepareCall(passwordUpdate);
            ps.executeUpdate();
            System.err.println("Kullanıcı şifresi güncellendi= "+ users.getPassword());
            return true;
        }
        catch (SQLException s){
            s.printStackTrace();
            System.err.println("Şifre güncellenmedi");
        }
        finally {
            dbConnection.closeConnection(con);
        }
        return false;
    }

    public List<Users> getUsers(){

        con = dbConnection.getCon(); // connetion açtık
        String getUsers = "select * from users";
        List<Users> usersList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareCall(getUsers);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){

                Users users = new Users();
                users.setId(resultSet.getInt("id"));
                users.setEmail(resultSet.getString("email"));
                users.setName(resultSet.getString("name"));
                users.setLastname(resultSet.getString("lastname"));
                users.setPassword(resultSet.getString("password"));

                usersList.add(users);
                System.out.println(users);
            }
            return usersList;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Liste yok");
        }
        finally {
            dbConnection.closeConnection(con);
        }
        return null;
    }
}
    
