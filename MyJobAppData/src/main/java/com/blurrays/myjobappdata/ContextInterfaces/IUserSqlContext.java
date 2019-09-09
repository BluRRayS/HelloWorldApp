package com.blurrays.myjobappdata.ContextInterfaces;

import com.blurrays.myjobappinterfaces.IUser;

public interface IUserSqlContext {

    void createUser(IUser user);
    void updateUser(IUser user);
    void deleteUser(IUser user);
    IUser getUserById(int id);
    Boolean emailIsNotTaken(String email);
    Boolean credentialsMatch(String email, String password);
    String getUserSalt(String email);
}
