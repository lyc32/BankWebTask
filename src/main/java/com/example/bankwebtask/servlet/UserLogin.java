package com.example.bankwebtask.servlet;

import com.example.bankwebtask.model.User;
import com.example.bankwebtask.severice.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UserLogin", value = "/UserLogin")
public class UserLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession httpSession = request.getSession();
        User user= (User)httpSession.getAttribute("user");

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
                ServletContext servletContext = getServletContext();
                String sqlDriver  = servletContext.getInitParameter("SqlDriver");
                String sqlUrl     = servletContext.getInitParameter("SqlUrl");
                String sqlUserName= servletContext.getInitParameter("SqlUserName");
                String sqlPassword= servletContext.getInitParameter("SqlPassWord");

                UserService userService = new UserService(sqlDriver,sqlUrl,sqlUserName,sqlPassword);
                user = userService.login(email, password);
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
