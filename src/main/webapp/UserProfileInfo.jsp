<%@ page import="com.example.bankwebtask.model.User" %>
<%
    HttpSession httpSession = request.getSession();
    User user = (User)httpSession.getAttribute("user");
    int id = -1;
    String userName = "";
    String accountType = "";
    if(user!=null)
    {
        id = user.getUserId();
        userName = user.getFirstName() + " " + user.getLastName();
        accountType = user.getAccountType();
    }
%>

<div class="card-body">
    <h3 class="card-title text-center border-bottom  pb-4">Info</h3>
    <p class="card-text">
    <div class="row g-3">
        <p class="card-text pt-2">
            <div class="row">
                <div class="col-sm-4 text-end">
                    <label class="col-sm-4 col-form-label">Customer ID: </label>
                </div>
                <div class="col-sm-8 text-start">
                    <label class="col-sm-4 col-form-label"><%=id%></label>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4 text-end">
                    <label class="col-sm-4 col-form-label">User Name: </label>
                </div>
                <div class="col-sm-8 text-start">
                    <label class="col-sm-4 col-form-label"><%=userName%></label>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4 text-end">
                    <label class="col-sm-4 col-form-label">Account Type: </label>
                </div>
                <div class="col-sm-8 text-start">
                    <label class="col-sm-4 col-form-label"><%=accountType%></label>
                </div>
            </div>
        </p>
    </div>
    </p>
</div>

