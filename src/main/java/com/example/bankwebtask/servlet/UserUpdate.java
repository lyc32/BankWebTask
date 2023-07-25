package com.example.bankwebtask.servlet;

import com.example.bankwebtask.model.Address;
import com.example.bankwebtask.model.Customer;
import com.example.bankwebtask.severice.CustomerService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UserOperation", value = "/UserOperation")
public class UserUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Customer customer = (Customer) request.getSession().getAttribute("user");
        String message;
        String url;
        String jumpPage;

        if(customer!=null)
        {
            String operation = request.getParameter("operation");
            if(operation.equals("updatePassword"))
            {
                String oldPassword = request.getParameter("oldPassword");
                String password = request.getParameter("password");
                if(customer.getUserPass().equals(oldPassword))
                {
                    if(CustomerService.updatePassword(customer.getUserId(),password))
                    {
                        customer.setUserPass(password);
                        request.getSession().setAttribute("user", customer);
                        message = ":) Your Password Update Successful";
                        url = "./index.jsp?location=MyAccount&view=Info";
                        jumpPage = "/index.jsp?location=UpdateSuccessful";
                    }
                    else
                    {
                        message = "Sorry, a DataBase Error Occurred :( <br>Can Not Update Your Password<br>Please Try Again";
                        url = "./index.jsp?location=MyAccount&view=Password";
                        jumpPage = "/index.jsp?location=DataBaseError";
                    }
                }
                else
                {
                    message = "You Current Password is not right :( <br>Please Try Again";
                    url = "./index.jsp?location=MyAccount&view=Password";
                    jumpPage = "/index.jsp?location=UnauthorizedAccess";
                }
            }
            else if(operation.equals("requestNewEmail"))
            {
                String oldEmail = request.getParameter("oldEmail");
                String email = request.getParameter("email");

                if(CustomerService.requestEmail(customer.getUserId(), oldEmail, email))
                {
                    message = ":) Your Request Has send to Manager";
                    url = "./index.jsp?location=MyAccount&view=MyRequest";
                    jumpPage = "/index.jsp?location=RequestSuccessful";
                }
                else
                {
                    message = "Sorry, a DataBase Error Occurred :( <br>Can Not Send Your Request To Manager<br>Please Try Again";
                    url = "./index.jsp?location=MyAccount&view=Email";
                    jumpPage = "/index.jsp?location=DataBaseError";
                }
            }
            else if(operation.equals("requestNewPhone"))
            {
                String oldPhone = request.getParameter("oldPhone");
                String Phone = request.getParameter("phone");

                if(CustomerService.requestPhone(customer.getUserId(), oldPhone, Phone))
                {
                    message = ":) Your Request Has send to Manager";
                    url = "./index.jsp?location=MyAccount&view=MyRequest";
                    jumpPage = "/index.jsp?location=RequestSuccessful";
                }
                else
                {
                    message = "Sorry, a DataBase Error Occurred :( <br>Can Not Send Your Request To Manager<br>Please Try Again";
                    url = "./index.jsp?location=MyAccount&view=Email";
                    jumpPage = "/index.jsp?location=DataBaseError";
                }
            }
            else if(operation.equals("requestNewAddress"))
            {
                String addressLine1 = request.getParameter("addressLine1");
                String addressLine2 = request.getParameter("addressLine2");
                String addressCity  = request.getParameter("addressCity");
                String addressState = request.getParameter("addressState");
                String addressZip   = request.getParameter("addressZipCode");

                Address address = new Address(addressLine1,addressLine2,addressCity,addressState,addressZip);

                if(CustomerService.requestAddress(customer.getUserId(), customer.getAddress(), address))
                {
                    message = ":) Your Request Has send to Manager";
                    url = "./index.jsp?location=MyAccount&view=MyRequest";
                    jumpPage = "/index.jsp?location=RequestSuccessful";
                }
                else
                {
                    message = "Sorry, a DataBase Error Occurred :( <br>Can Not Send Your Request To Manager<br>Please Try Again";
                    url = "./index.jsp?location=MyAccount&view=Address";
                    jumpPage = "/index.jsp?location=DataBaseError";
                }
            }
            else
            {
                message = "404 Unknown Operation :( ";
                url = "./index.jsp";
                jumpPage = "/index.jsp?location=UnauthorizedAccess";
            }
        }
        else
        {
            message = "Unauthorized access :( <Br>You have Log Out";
            url = "./index.jsp?location=Login";
            jumpPage = "/index.jsp?location=UnauthorizedAccess";
        }

        response.setContentType("text/html");
        ServletContext sc = getServletContext();
        request.setAttribute("message", message);
        request.setAttribute("url",url);
        RequestDispatcher rd = sc.getRequestDispatcher(jumpPage);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request,response);
    }


}
