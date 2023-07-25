<div class="container mt-4 mb-4 pt-4" style="min-height: 800px;">
    <div class="row g-3 my-2" style="min-height: 600px;">
        <div class="col-sm-2 card border" style="width:200px;">
            <div class="card-body  text-center">
                <h3 class="card-title text-center border-bottom  pb-4">My Profile</h3>
                <p class="card-text">
                <div class="row g-3">
                    <div class="col-sm-12 border-bottom">
                        <a class="col-form-label h3" href="./index.jsp?location=MyAccount&view=Info">Info</a>
                    </div>
                    <div class="col-sm-12 border-bottom">
                        <a class="col-form-label h3" href="./index.jsp?location=MyAccount&view=Phone">Phone Number</a>
                    </div>
                    <div class="col-sm-12 border-bottom">
                        <a class="col-form-label h3" href="./index.jsp?location=MyAccount&view=Email">E-mail</a>
                    </div>
                    <div class="col-sm-12 border-bottom">
                        <a class="col-form-label h3" href="./index.jsp?location=MyAccount&view=Address">Mail Address</a>
                    </div>
                    <div class="col-sm-12 border-bottom">
                        <a class="col-form-label h3" href="./index.jsp?location=MyAccount&view=Password">Reset Password</a>
                    </div>
                    <div class="col-sm-12 border-bottom">
                        <a class="col-form-label h3" href="./index.jsp?location=MyAccount&view=MyRequest">MyRequest</a>
                    </div>
                    <div class="col-sm-12 border-bottom">
                        <a class="col-form-label h3" href="./index.jsp?location=MyAccount&view=TransactionHistory">TransactionHistory</a>
                    </div>
                    <div class="col-sm-12 border-bottom">
                        <a class="col-form-label h3" href="./index.jsp?location=MyAccount&view=Statement">Get Statement</a>
                    </div>
                </div>
                </p>
            </div>
        </div>
        <div class="col-sm-10">
            <div class="card border">
            <%
                String view = (String)request.getParameter("view");
                if(view == null || view.equals("Info"))
                {
            %>
            <jsp:include page="UserProfileInfo.jsp" flush="true"/>
            <%
            }
            else if(view.equals("Address"))
            {
            %>
            <jsp:include page="UserProfileAddress.jsp" flush="true"/>
            <%
            }
            else if(view.equals("MyRequest"))
            {
            %>
            <jsp:include page="UserProfileRequest.jsp" flush="true"/>
            <%
            }
            else if(view.equals("Email"))
            {
            %>
            <jsp:include page="UserProfileEmail.jsp" flush="true"/>
            <%
            }
            else if(view.equals("Phone"))
            {
            %>
            <jsp:include page="UserProfilePhone.jsp" flush="true"/>
            <%
            }
            else if(view.equals("Statement"))
            {
            %>
            <jsp:include page="UserProfileStatement.jsp" flush="true"/>
            <%
            }
            else if(view.equals("TransactionHistory"))
            {
            %>
            <jsp:include page="UserProfileTransactionHistory.jsp" flush="true"/>
            <%
            }
            else if(view.equals("Password"))
            {
            %>
            <jsp:include page="UserProfilePassword.jsp" flush="true"/>
            <%
            }
            %>
            </div>
        </div>
    </div>
</div>
