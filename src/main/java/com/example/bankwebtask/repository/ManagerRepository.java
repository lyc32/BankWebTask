package com.example.bankwebtask.repository;

import com.example.bankwebtask.database.JdbcCRUD;
import com.example.bankwebtask.model.Address;
import com.example.bankwebtask.model.Customer;
import com.example.bankwebtask.model.Manager;
import com.example.bankwebtask.model.User;
import com.example.bankwebtask.severice.ManagerService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerRepository
{
    public static String managerTable = "ManagerTable";

    public static Manager login(Connection connection, String email, String password)
    {
        ResultSet resultSet = new JdbcCRUD().searchData(connection,"*", managerTable, "email='"+email+"' AND userPass='"+password+"'");
        if(resultSet!=null)
        {
            Manager manager = null;
            while (true)
            {
                try
                {
                    if(! resultSet.next() )
                    {
                        break;
                    }
                    else
                    {
                        manager = new Manager( );
                        manager.setUserId(Integer.parseInt(resultSet.getString("userId")));
                    }
                }
                catch (SQLException e)
                {
                    throw new RuntimeException(e);
                }
            }
            return manager;
        }
        return null;
    }
}
