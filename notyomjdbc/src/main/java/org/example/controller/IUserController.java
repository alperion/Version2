package org.example.controller;

import org.example.entity.Users;

import java.util.List;

public interface IUserController {
    public boolean isExist(String email, String password);
    public boolean save(String email, String password);
    public boolean updateMail(String updateMail,String email1,String password1);
    public boolean updateName(String name,String email);
    public boolean usersUpdateLastName(String lastname,String email);
    public boolean updatePassword(String password,String email);
    public List<Users> getUsers();
}
