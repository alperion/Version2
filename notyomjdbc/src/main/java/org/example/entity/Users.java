package org.example.entity;

public class Users {
    private int id;
    private String name;
    private String lastname;
    private String email;
    private String password;

    public Users(String name, String lastname, String email, String password) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public Users() {
    }

    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static class UserBuilder{

        private int id;
        private String name;
        private String surname;
        private String email;
        private String password;

        public UserBuilder Id(int id) {
            this.id = id;
            return this;
        }
        public UserBuilder Name(String name) {
            this.name = name;
            return this;
        }
        public UserBuilder Surname(String surname) {
            this.surname = surname;
            return this;
        }
        public UserBuilder eMail(String email) {
            this.email = email;
            return this;
        }
        public UserBuilder Password(String password) {
            this.password = password;
            return this;
        }

        public static UserBuilder startUserBuilder(){
            return new UserBuilder();
        }
        public Users build(){
            Users users = new Users();
            users.setId(id);
            users.setName(name);
            users.setLastname(surname);
            users.setEmail(email);
            users.setPassword(password);
            return users;
        }

    }





}

