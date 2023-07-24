package com.example.bankwebtask.severice;

import com.example.bankwebtask.database.ConnectDB;
import com.example.bankwebtask.model.*;
import java.sql.Connection;
import com.example.bankwebtask.repository.*;

public class UserService
{
    private static Connection connection = null;
    private static int currentUserID = -1;

    public UserService(String driver, String url, String userName, String password)
    {
        if (connection == null)
        {
            ConnectDB connectDB = new ConnectDB(driver, url, userName, password);
            if (connectDB.connectToDataBase())
            {
                connection = connectDB.getConnection();
            }
        }
        if(connection!=null)
        {
            if(currentUserID < 0)
            {
                int result = UserRepository.creatUserTable(connection);
                if(result == 0)
                {
                    currentUserID = UserRepository.getCurrentUserID(connection);
                }
                else if(result == 1)
                {
                    currentUserID = 0;
                }
                else
                {
                    currentUserID = -1;
                }
            }
        }
    }

    public boolean addNewUser(User user)
    {
        if(connection == null)
        {
            System.out.println("[DataBase Connection Error]: Can not access to the Database");
            return false;
        }
        if(!UserRepository.addNewRecord(connection, user))
        {
            System.out.println("[DataBase Insert Failed]: Can not insert new Record");
            return false;
        }
        else
        {
            currentUserID++;
            return true;
        }
    }

    public User login(String email, String password)
    {
        if(connection == null)
        {
            System.out.println("[DataBase Connection Error]: Can not access to the Database");
            return null;
        }

        return UserRepository.login(connection, email, password);
    }



}
