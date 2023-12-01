package org.example.repository;

import org.example.entity.Users;

import java.util.List;

public interface IUserRepository {
    public boolean save(Users users);
    public Users isExist(String email, String password);
    public boolean updateMail(Users Users, String updateMail);
    public boolean updateName(Users Users);
    public boolean updateSurname(Users Users);
    public boolean updatePassword(Users Users);
    public List<Users> getUsers();
}
