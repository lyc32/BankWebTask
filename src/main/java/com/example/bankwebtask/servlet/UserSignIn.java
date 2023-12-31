package com.example.bankwebtask.servlet;

import com.example.bankwebtask.model.Address;
import com.example.bankwebtask.model.Customer;
import com.example.bankwebtask.model.User;
import com.example.bankwebtask.severice.CustomerService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UserSignIn", value = "/UserSignIn")
public class UserSignIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession httpSession = request.getSession();
        User user= (User)httpSession.getAttribute("user");

        // user already login
        if(user != null)
        {
            response.setContentType("text/html");
            ServletContext sc = getServletContext();
            request.setAttribute("message", "You Are Already Login :)");
            request.setAttribute("url","./index.jsp");
            RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp?location=AlreadyLogin");
            rd.forward(request, response);
        }
        else
        {
            Address address = new Address(request.getParameter("addressLine1"), request.getParameter("addressLine2"), request.getParameter("addressCity"), request.getParameter("addressState"), request.getParameter("addressZipCode"));
            user = new Customer(request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("password"), request.getParameter("phone"), request.getParameter("email"), request.getParameter("accountType"), address, "active");
            if( CustomerService.addNewUser((Customer) user))
            {
                response.setContentType("text/html");
                ServletContext sc = getServletContext();
                request.setAttribute("message", "SignIn Successful :)");
                request.setAttribute("url","./index.jsp?location=Login");
                RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp?location=AddUserSuccessful");
                rd.forward(request, response);
            }
            else
            {
                response.setContentType("text/html");
                ServletContext sc = getServletContext();
                request.setAttribute("message", "Cannot Add User :( <Br>Please try again");
                request.setAttribute("url","./index.jsp?location=SignIn");
                RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp?location=AddUserFailed");
                rd.forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request,response);
    }

}
