package com.example.bankwebtask.severice;

import com.example.bankwebtask.model.User;
import com.example.bankwebtask.repository.*;

public class ManagerService extends Service
{
    public static User login(String email, String password)
    {
        if((connection == null)||(tableExist==false))
        {
            System.out.println("[DataBase Connection Error]: Can not access to the Database");
            return null;
        }

        return ManagerRepository.login(connection, email, password);
    }
}
