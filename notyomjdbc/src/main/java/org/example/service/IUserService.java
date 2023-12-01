package org.example.service;

import org.example.entity.Users;

public interface IUserService extends BaseServiceMethods<Users>{
    public boolean isExist(String email,String password);
    public boolean updateMail(String updateMail,String email,String password);
    public boolean updateName(String name,String email);
    public boolean updateSurname(String lastname,String email);
    public boolean updatePassword(String password,String email);
}
