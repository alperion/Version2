package org.example.controller;

import org.example.entity.Users;
import org.example.service.IUserService;
import org.example.service.UserService;
import org.example.utility.Singleton;

import java.util.List;

public class UserController implements IUserController{
    IUserService userService;



    public UserController(){
        userService = Singleton.getUserService();
    }

    public boolean isExist(String email, String password) {
        return userService.isExist(email, password);
    }
    public boolean save(String email, String password) {
        Users users=Users.UserBuilder.startUserBuilder().eMail(email).Password(password).build();

        return userService.save(users);
    }
    public boolean updateMail(String updateMail,String email1,String password1){
        return userService.updateMail(updateMail,email1,password1);
    }
    public boolean updateName(String updateName,String email){
        return userService.updateName(updateName,email);

    }
    public boolean usersUpdateLastName(String lastname,String email){
        return userService.updateSurname(lastname,email);
    }
    public boolean updatePassword(String password,String email){
        return userService.updatePassword(password,email);
    }
    public List<Users> getUsers(){
        return userService.getAll();
    }






}
