<%@ page import="com.example.bankwebtask.model.*" %>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="./index.jsp?location=HomePage">BankWeb</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ">
                <li class="nav-item">
                    <a class="nav-link" href="./index.jsp?location=MyAccount&view=Info">MyBalance</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./index.jsp?location=MyAccount&view=Statement">MyStatement</a>
                </li>
            </ul>
        </div>
        <div class="collapse navbar-collapse justify-content-end">
            <ul class="navbar-nav ">
                <li class="nav-item dropdown text-center" style = "min-width:160px">
                    <a href="#" class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown">
                        <%
                            User user = (User) request.getSession().getAttribute("user");
                            String userName;
                            userName = (user == null) ? "Log In": user.getFirstName() + " " + user.getLastName();
                            out.println(userName);
                        %>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-end text-center">
                        <%
                            if(userName.equals("Log In"))
                            {
                                out.println("<li><a class=\"dropdown-item\" href=\"./index.jsp?location=Login\">Log in</a></li>" +
                                            "<li><a class=\"dropdown-item\" href=\"./index.jsp?location=SignIn\">Sign In</a></li>");
                            }
                            else
                            {
                                out.println("<li><a class=\"dropdown-item\" href=\"./index.jsp?location=MyAccount\">My Profile</a></li>\n" +
                                            "<li><a class=\"dropdown-item\" href=\"Logout\">Log out</a></li>");
                            }
                        %>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
