package com.example.bankwebtask.repository;


import com.example.bankwebtask.database.*;
import com.example.bankwebtask.model.Address;
import com.example.bankwebtask.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository
{
    private static String userTable = "UserTable";

    public static int creatUserTable(Connection connection)
    {
        return new TableOperation().creatTable(connection, userTable,
                "(" +
                        "userId int(10) PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
                        "firstName varchar(20), " +
                        "lastName varchar(20), " +
                        "userPass varchar(30), " +
                        "phoneNumber varchar(15), " +
                        "email varchar(20), " +
                        "accountType varchar(20), " +
                        "balance Double, " +
                        "Address varchar(1000)," +
                        "state varchar(10))");
    }

    public static int getCurrentUserID(Connection connection)
    {
        ResultSet resultSet = new JdbcCRUD().searchData(connection, "table_name, AUTO_INCREMENT", "information_schema.tables", "table_name='"+ userTable +"'");
        while (true)
        {
            try
            {
                if (!resultSet.next())
                    break;
                return resultSet.getInt("AUTO_INCREMENT") - 1;
            }
            catch (SQLException e)
            {
                return -1;
            }
        }
        return -1;
    }

    public static boolean addNewRecord(Connection connection, User user)
    {
        int result = new JdbcCRUD().insertData(connection,
                "`"+ userTable +"`",
                "(`firstName`, `lastName`, `userPass`, `phoneNumber`, `email`, `accountType`, `balance`,`address`,`state`)",
                "('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getUserPass()+"','"+user.getPhoneNumber()+"','"+user.getEmail()+"','"+user.getAccountType()+"',"+user.getBalance()+",'"+user.getAddress().toJson()+"','"+user.getState()+"')");
        if (result == 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public static User login(Connection connection, String email, String password)
    {
        ResultSet resultSet = searchRecords(connection, "email='"+email+"' AND userPass='"+password+"'");
        if(resultSet!=null)
        {
            User user = null;
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
                        user = new User(resultSet.getString("firstName"),
                                resultSet.getString("lastName"),
                                resultSet.getString("userPass"),
                                resultSet.getString("phoneNumber"),
                                resultSet.getString("email"),
                                resultSet.getString("accountType"),
                                new Address(resultSet.getString("address")),
                                resultSet.getString("state"));
                    }
                }
                catch (SQLException e)
                {
                    throw new RuntimeException(e);
                }
            }
            return user;
        }
        return null;
    }

    public static ResultSet getAllRecords(Connection connection)
    {
        return new JdbcCRUD().getAllData(connection, "*", userTable);
    }

    public static ResultSet searchRecords(Connection connection, String whereCondition)
    {
        return new JdbcCRUD().searchData(connection,"*", userTable, whereCondition);
    }

    public static Boolean deleteRecords(Connection connection, String whereCondition)
    {
        int result = new JdbcCRUD().deleteData(connection, userTable, whereCondition);
        if( result!=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static Boolean updateRecords(Connection connection, String whereCondition, User user)
    {
        int result = new JdbcCRUD().updateData(connection, userTable, "", whereCondition);
        if( result!=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
