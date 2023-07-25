<%@ page import="com.example.bankwebtask.model.*" %>
<%
    HttpSession httpSession = request.getSession();
    Customer customer = (Customer)httpSession.getAttribute("user");
    if(customer ==null)
    {
        customer = new Customer();
    }
%>
<div class="card-body">
    <h3 class="card-title text-center p-4">Customer ID: <%=customer.getUserId()%></h3>
    <div class="row g-3 border-top">
        <div class="col-sm-5">
            <div class="row pt-2 pb-2">
                <div class="col-sm-6 text-end">
                    <label class="col-form-label">User Name:</label>
                </div>
                <div class="col-sm-6">
                    <label class="col-form-label"><h5><%=customer.getFirstName() + " " + customer.getLastName()%></h5></label>
                </div>
            </div>
            <div class="row pt-2 pb-2">
                <div class="col-sm-6 text-end">
                    <label class="col-form-label">Account Type:</label>
                </div>
                <div class="col-sm-6">
                    <label class="col-form-label"><h5><%=customer.getAccountType()%></h5></label>
                </div>
            </div>
            <div class="row pt-2 pb-2">
                <div class="col-sm-6 text-end">
                    <label class="col-form-label">Balance:</label>
                </div>
                <div class="col-sm-6">
                    <label class="col-form-label"><h5><%=customer.getBalance()%></h5></label>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="row pt-2 pb-2">
                <div class="col-sm-4 text-end">
                    <label class="col-form-label">Phone:</label>
                </div>
                <div class="col-sm-8">
                    <label class="col-form-label"><h5><%=customer.getPhoneNumber()%></h5></label>
                </div>
            </div>
            <div class="row pt-2 pb-2">
                <div class="col-sm-4 text-end">
                    <label class="col-form-label">E-mail:</label>
                </div>
                <div class="col-sm-8">
                    <label class="col-form-label"><h5><%=customer.getEmail()%></h5></label>
                </div>
            </div>
            <div class="row pt-2 pb-2">
                <div class="col-sm-4 text-end">
                    <label class="col-form-label">Address:</label>
                </div>
                <div class="col-sm-8">
                    <div class="row h5">
                        <div class="col-sm-8"><label class="col-form-label"><h5><%=customer.getAddress().getLine1()%></h5></label></div>
                        <div class="col-sm-8"><label class="col-form-label"><h5><%=customer.getAddress().getLine2()%></h5></label></div>
                        <div class="col-sm-8"><label class="col-form-label"><h5><%=customer.getAddress().getCity() + ", " + customer.getAddress().getState()%></h5></label></div>
                        <div class="col-sm-8"><label class="col-form-label"><h5><%=customer.getAddress().getZipCode()%></h5></label></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>



