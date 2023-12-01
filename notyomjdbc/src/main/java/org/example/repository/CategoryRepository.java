package org.example.repository;

import org.example.entity.Category;
import org.example.utility.DbConnection;
import org.example.utility.Singleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CategoryRepository implements ICategoryRepository{
    DbConnection dbConnection;

    public CategoryRepository() {
        dbConnection= Singleton.getDbConnection();
    }

    public void save(String categoryName){
        Connection con=dbConnection.getCon();
        String insertSorgu= "insert into category(name) values('"+categoryName+"')";
        try {
            PreparedStatement pr=con.prepareCall(insertSorgu);
            pr.executeUpdate();
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }finally {
            dbConnection.closeConnection(con);
        }
    }

    public  Category getByName(String name){
        Connection con=dbConnection.getCon();
        String sqlName="select * from category where category.name='"+name+"'";
        try{
            Driver.class.forName("org.postgresql.Driver");
            PreparedStatement pr=con.prepareCall(sqlName);
            ResultSet set=pr.executeQuery();
            Category category=new Category();
            while (set.next()){
                int tableId=set.getInt("id");
                String tableName=set.getString("name");
                category.setId(tableId);
                category.setName(tableName);
            }
            return category;
        } catch (ClassNotFoundException e) {
            System.out.println("Driver hatası aldık");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbConnection.closeConnection(con);
        }
        return null;
    }
    public void delete(String categoryName){
        Connection con=dbConnection.getCon();

        String deleteSorgu= "DELETE FROM category WHERE name='"+categoryName+"'";
        try {
            PreparedStatement pr=con.prepareCall(deleteSorgu);
            pr.executeUpdate();
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }finally {
            dbConnection.closeConnection(con);
        }
    }
    public List<Category> getAll(){
        Connection con= dbConnection.getCon();

        String selectSorgu="select * from category";
        PreparedStatement pp= null;
        try {
            pp = con.prepareCall(selectSorgu);
            ResultSet set=pp.executeQuery();

            List<Category>categories=new ArrayList<>();
            while (set.next()){
                int id=set.getInt("id");
                String name=set.getString("name");
                Category category=new Category();
                category.setId(id);
                category.setName(name);
                categories.add(category);
                System.out.println(category);
            }
            return categories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            dbConnection.closeConnection(con);
        }
    }
}
