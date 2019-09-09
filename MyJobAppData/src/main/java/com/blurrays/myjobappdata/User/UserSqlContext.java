package com.blurrays.myjobappdata.User;

import com.blurrays.myjobappdata.ContextInterfaces.IUserSqlContext;
import com.blurrays.myjobappdata.DatabaseConnection;
import com.blurrays.myjobappinterfaces.IUser;

import java.io.Console;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UserSqlContext implements IUserSqlContext {

    private DatabaseConnection _connection;

    UserSqlContext() {
        _connection = new DatabaseConnection();
    }


    @Override
    public void createUser(IUser user) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO [User](Email,Password,Salt,Firstname,Lastname,Phone,DateOfBirth,Type) VALUES(?,?,?,?,?,?,?,?)");
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getSalt());
            statement.setString(4, user.getFirstname());
            statement.setString(5, user.getLastname());
            statement.setString(6, user.getPhone());
            statement.setDate(7, java.sql.Date.valueOf(user.getDateOfBirth()));
            statement.setInt(8, (user.getType().ordinal()));
            int i = statement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("Sql Exception:" + e.getMessage());
        }


    }

    @Override
    public void updateUser(IUser user) {

    }

    @Override
    public void deleteUser(IUser user) {

    }

    @Override
    public IUser getUserById(int id) {
        return null;
    }

    @Override
    public Boolean emailIsNotTaken(String email) {
        return null;
    }

    @Override
    public Boolean credentialsMatch(String email, String password) {
        return null;
    }

    @Override
    public String getUserSalt(String email) {
        return null;
    }

}
