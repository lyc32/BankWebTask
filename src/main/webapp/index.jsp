<%@ page import="com.example.bankwebtask.severice.Service" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    //ServletContext servletContext = this.getServletContext();
    String sqlDriver  = "com.mysql.cj.jdbc.Driver";
    String sqlUrl     = "jdbc:mysql://localhost:3306/BankWebTask?useSSL=false";
    String sqlUserName= "root";
    String sqlPassword= "";
    Service.init(sqlDriver,sqlUrl,sqlUserName,sqlPassword);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="head.jsp" %>
</head>
<body>
<%@ include file="header.jsp" %>
<%
    String location = (String)request.getParameter("location");
    if(location == null || location.equals("HomePage"))
    {
%>
<jsp:include page="HomePage.jsp" flush="true"/>
<%
    }
    else if(location.equals("Login"))
    {
%>
<jsp:include page="Login.html" flush="true"/>
<%
    }
    else if(location.equals("SignIn"))
    {
%>
<jsp:include page="UserSignIn.html" flush="true"/>
<%
    }
    else if(location.equals("MyAccount"))
    {
%>
<jsp:include page="UserProfile.jsp" flush="true"/>
<%
    }
    else
    {
%>
<jsp:include page="JumpPage.jsp" flush="true"/>
<%
    }
%>

<%@ include file="footer.jsp" %>
</body>
</html>
