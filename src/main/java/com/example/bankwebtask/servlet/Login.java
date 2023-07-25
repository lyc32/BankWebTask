package com.example.bankwebtask.servlet;

import com.example.bankwebtask.model.*;
import com.example.bankwebtask.severice.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UserLogin", value = "/UserLogin")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession httpSession = request.getSession();
        User user = (User)httpSession.getAttribute("user");
        if(user != null)
        {
            response.setContentType("text/html");
            ServletContext sc = getServletContext();
            request.setAttribute("message", "You Are Already Login :)");
            request.setAttribute("url","./index.jsp");
            RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp?location=UnauthorizedAccess");
            rd.forward(request, response);
        }
        else
        {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            // first time visit ../login
            if(email==null || password==null)
            {
                response.setContentType("text/html");
                ServletContext sc = getServletContext();
                request.setAttribute("message", "Unauthorized access :( <Br>Email Or Password Is null");
                request.setAttribute("url","./index.jsp");
                RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp?location=UnauthorizedAccess");
                rd.forward(request, response);
            }
            // check user email and password
            else
            {
                String manager = request.getParameter("manager");
                if(manager == null)
                {
                    user = new CustomerService().login(email, password);
                }
                else
                {
                    user = new ManagerService().login(email, password);
                }

                // find a user
                if (user!=null)
                {
                    response.setContentType("text/html");
                    ServletContext sc = getServletContext();
                    RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp?location=LoginSuccessful");
                    String userName = user.getFirstName() + " " + user.getLastName();
                    httpSession.setAttribute("user", user);
                    request.setAttribute("message", ":) welcome back " + userName );
                    request.setAttribute("url", "./index.jsp");
                    request.setAttribute("userName", userName);
                    rd.forward(request, response);
                }
                // may be database error
                // may be sever error
                // may be email and password do not match.
                else
                {
                    response.setContentType("text/html");
                    ServletContext sc = getServletContext();
                    RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp?location=LoginFailed");
                    request.setAttribute("message","Login Failed :( <br> Your E-mail ID and Password Don't Match.");
                    request.setAttribute("url", "./index.jsp?location=Login");
                    rd.forward(request, response);
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}
