package model;

import java.util.ArrayList;

public class UsersOnline {
/*
* امیر
1212
@0579b67c
09143081984
amir.m.jvd.1.1@gmail.com
کاربر*/
    private String name;
    private String password;
    private String username;
    private String phoneNumber;
    private String email;
    private String type;

    static ArrayList<UsersOnline> usersOnlineList = new ArrayList<UsersOnline>();

    public UsersOnline(String name, String password, String username, String phoneNumber, String email, String type) {
        this.name = name;
        this.password = password;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.type = type;
    }

    public void setUsersOnlineList() {
        usersOnlineList.add(this);
    }

    public static void changeUserName(String oldUserName, String newUserName) {
        for (UsersOnline user : usersOnlineList) {
            if (user.getName().equals(oldUserName)) {
                user.setName(newUserName);
            }
        }
    }

    public static void changePassword(String username,String oldPassword, String newPassword) {
        for (UsersOnline user : usersOnlineList) {
            if (user.getName().equals(username) && user.getPassword().equals(oldPassword)) {
                user.setPassword(newPassword);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
