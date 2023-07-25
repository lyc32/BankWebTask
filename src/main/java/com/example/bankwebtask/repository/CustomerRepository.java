package com.example.bankwebtask.repository;


import com.example.bankwebtask.database.*;
import com.example.bankwebtask.model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository
{
    public static String userTable = "UserTable";
    public static String userRequestTable = "UserRequestTable";
    public static String userTransactionTable = "UserTransactionTable";

    public static boolean addNewUser(Connection connection, Customer user)
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

    public static Customer login(Connection connection, String email, String password)
    {
        ResultSet resultSet = new JdbcCRUD().searchData(connection,"*", userTable, "email='"+email+"' AND userPass='"+password+"'");
        if(resultSet!=null)
        {
            Customer customer = null;
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
                        customer = new Customer(resultSet.getString("firstName"),
                                resultSet.getString("lastName"),
                                resultSet.getString("userPass"),
                                resultSet.getString("phoneNumber"),
                                resultSet.getString("email"),
                                resultSet.getString("accountType"),
                                new Address(resultSet.getString("address")),
                                resultSet.getString("state"));
                        customer.setUserId(Integer.parseInt(resultSet.getString("userId")));
                    }
                }
                catch (SQLException e)
                {
                    throw new RuntimeException(e);
                }
            }
            return customer;
        }
        return null;
    }

    public static Boolean updatePassword(Connection connection, int userId, String password)
    {
        int result = new JdbcCRUD().updateData(connection, userTable, "userPass='" + password + "'", "userId=" + userId);
        if( result!=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean addNewRequest(Connection connection, UserRequest userRequest)
    {
        int result = new JdbcCRUD().insertData(connection,
                "`"+ userRequestTable +"`",
                "(`userId`, `columnName`, `oldData`, `newData`, `state`)",
                "("+userRequest.getUserId()+",'"+userRequest.getColumnName()+"','"+userRequest.getOldData()+"','"+userRequest.getNewData()+"','"+userRequest.getState()+"')");
        if (result == 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public static List<UserRequest> getUserRequest(Connection connection, int userId)
    {
        List<UserRequest> userRequestList = new ArrayList<>();
        ResultSet resultSet = new JdbcCRUD().searchData(connection,"*", userRequestTable, "userId=" + userId);
        if(resultSet!=null)
        {
            UserRequest userRequest = null;
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
                        userRequest = new UserRequest(Integer.parseInt(resultSet.getString("userId")),
                                resultSet.getString("columnName"),
                                resultSet.getString("oldData"),
                                resultSet.getString("newData"),
                                resultSet.getString("state"));
                        userRequest.setRequestId(Integer.parseInt(resultSet.getString("requestId")));
                        userRequestList.add(userRequest);
                    }
                }
                catch (SQLException e)
                {
                    throw new RuntimeException(e);
                }
            }
            return userRequestList;
        }
        return userRequestList;
    }

    public static List<Transaction> getUserTransaction(Connection connection, int userId)
    {
        List<Transaction> userTransactionList = new ArrayList<>();
        ResultSet resultSet = new JdbcCRUD().searchData(connection,"*", userRequestTable, "userId=" + userId);
        if(resultSet!=null)
        {
            Transaction transaction = null;
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

                        //String tDate, String userId, String object, String detail, double bill
                        transaction = new Transaction(
                                resultSet.getString("tDate"),
                                resultSet.getString("userId"),
                                resultSet.getString("object"),
                                resultSet.getString("detail"),
                                Double.parseDouble(resultSet.getString("bill")));
                        userTransactionList.add(transaction);
                    }
                }
                catch (SQLException e)
                {
                    throw new RuntimeException(e);
                }
            }
            return userTransactionList;
        }
        return userTransactionList;
    }
}
