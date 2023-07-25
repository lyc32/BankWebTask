package com.example.bankwebtask.severice;

import com.example.bankwebtask.database.ConnectDB;
import com.example.bankwebtask.database.TableOperation;
import com.example.bankwebtask.repository.CustomerRepository;
import com.example.bankwebtask.repository.ManagerRepository;

import java.sql.Connection;

public abstract class Service
{
    protected static Connection connection = null;
    protected static boolean tableExist = false;

    public static void init(String driver, String url, String userName, String password)
    {
        if (connection == null)
        {
            ConnectDB connectDB = new ConnectDB(driver, url, userName, password);
            if (connectDB.connectToDataBase())
            {
                connection = connectDB.getConnection();
            }
        }

        if((connection!=null)&&(tableExist==false))
        {
            if((creatUserTable(connection) >=0) && (creatUserRequest(connection) >=0) && (creatTransaction(connection) >=0) && (creatManagerTable(connection) >=0))
            {
                tableExist = true;
            }
        }
    }

    public static int creatUserTable(Connection connection)
    {
        return new TableOperation().creatTable(connection, CustomerRepository.userTable,
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

    public static int creatManagerTable(Connection connection)
    {
        return new TableOperation().creatTable(connection, ManagerRepository.managerTable,
                "(" +
                        "userId int(10) PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
                        "firstName varchar(20), " +
                        "lastName varchar(20), " +
                        "userPass varchar(30), " +
                        "phoneNumber varchar(15), " +
                        "email varchar(20), "+
                        "level int(10), ");
    }

    public static int creatUserRequest(Connection connection)
    {
        return new TableOperation().creatTable(connection, CustomerRepository.userRequestTable,
                "(" +
                        "requestId int(10) PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
                        "userId int(10), " +
                        "columnName varchar(1000), " +
                        "oldData varchar(1000), " +
                        "newData varchar(1000), " +
                        "state varchar(30))");
    }

    public static int creatTransaction(Connection connection)
    {
        return new TableOperation().creatTable(connection, CustomerRepository.userTransactionTable,
                "(" +
                        "id int(10) PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
                        "tDate Date, " +
                        "userId int(10), " +
                        "object varchar(1000), " +
                        "detail varchar(1000), " +
                        "bill double)");
    }

}
