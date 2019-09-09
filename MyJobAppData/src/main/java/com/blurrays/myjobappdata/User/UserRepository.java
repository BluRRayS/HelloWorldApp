package com.blurrays.myjobappdata.User;

import com.blurrays.myjobappdata.ContextInterfaces.IUserSqlContext;
import com.blurrays.myjobappinterfaces.IUser;

public class UserRepository {

    private IUserSqlContext _context;

    public UserRepository(IUserSqlContext context) {
        _context = context;
    }

    public void createUser(IUser user) {
        _context.createUser(user);
    }

    public void updateUser(IUser user) {
        _context.updateUser(user);
    }

    public void deleteUser(IUser user) {
        _context.deleteUser(user);
    }

    public IUser getUserById(int id) {
        return _context.getUserById(id);
    }

    public Boolean emailIsNotTaken(String email) {
        return _context.emailIsNotTaken(email);
    }

    public Boolean credentialsMatch(String email, String password) {
        return _context.credentialsMatch(email, password);
    }

    public String getUserSalt(String email) {
        return _context.getUserSalt(email);
    }

    public boolean isEmailTaken(String email) {
        //Todo: check in database  if email already exists!
        return false;
    }
}
