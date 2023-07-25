package com.example.bankwebtask.severice;

import com.example.bankwebtask.model.*;
import com.example.bankwebtask.repository.*;

import java.util.List;

public class CustomerService extends Service
{
    public static boolean addNewUser(Customer customer)
    {
        if((connection == null)||(tableExist==false))
        {
            System.out.println("[DataBase Connection Error]: Can not access to the Database");
            return false;
        }
        if(!CustomerRepository.addNewUser(connection, customer))
        {
            System.out.println("[DataBase Insert Failed]: Can not insert new Record");
            return false;
        }
        else
        {
            return true;
        }
    }

    public static Customer login(String email, String password)
    {
        if((connection == null)||(tableExist==false))
        {
            System.out.println("[DataBase Connection Error]: Can not access to the Database");
            return null;
        }
        return CustomerRepository.login(connection, email, password);
    }

    public static boolean updatePassword(int id, String password)
    {
        if((connection == null)||(tableExist==false))
        {
            System.out.println("[DataBase Connection Error]: Can not access to the Database");
            return false;
        }
        if(!CustomerRepository.updatePassword(connection, id, password))
        {
            System.out.println("[DataBase Insert Failed]: Can not insert new Record");
            return false;
        }
        else
        {
            return true;
        }
    }

    public static boolean requestEmail(int id, String oldEmail, String email)
    {
        if((connection == null)||(tableExist==false))
        {
            System.out.println("[DataBase Connection Error]: Can not access to the Database");
            return false;
        }

        if(!CustomerRepository.addNewRequest(connection, new UserRequest(id, "email", oldEmail, email, "OPEN")))
        {
            System.out.println("[DataBase Insert Failed]: Can not insert new Record");
            return false;
        }
        else
        {
            return true;
        }
    }

    public static boolean requestPhone(int id, String oldPhone, String phone)
    {
        if((connection == null)||(tableExist==false))
        {
            System.out.println("[DataBase Connection Error]: Can not access to the Database");
            return false;
        }

        if(!CustomerRepository.addNewRequest(connection, new UserRequest(id, "phoneNumber", oldPhone, phone, "OPEN")))
        {
            System.out.println("[DataBase Insert Failed]: Can not insert new Record");
            return false;
        }
        else
        {
            return true;
        }
    }

    public static boolean requestAddress(int id, Address oldAddress, Address address)
    {
        if((connection == null)||(tableExist==false))
        {
            System.out.println("[DataBase Connection Error]: Can not access to the Database");
            return false;
        }

        if(!CustomerRepository.addNewRequest(connection, new UserRequest(id, "phoneNumber", oldAddress.toJson(), address.toJson(), "OPEN")))
        {
            System.out.println("[DataBase Insert Failed]: Can not insert new Record");
            return false;
        }
        else
        {
            return true;
        }
    }

    public static List<UserRequest> getUserRequest(int userId)
    {
        if((connection == null)||(tableExist==false))
        {
            System.out.println("[DataBase Connection Error]: Can not access to the Database");
            return null;
        }
        return CustomerRepository.getUserRequest(connection, userId);
    }

    public static List<Transaction> getUserTransaction(int userId)
    {

        if((connection == null)||(tableExist==false))
        {
            System.out.println("[DataBase Connection Error]: Can not access to the Database");
            return null;
        }

        return CustomerRepository.getUserTransaction(connection, userId);
    }
}
