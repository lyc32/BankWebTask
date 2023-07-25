<%@ page import="com.example.bankwebtask.model.User" %><%
    HttpSession httpSession = request.getSession();
    User user = (User)httpSession.getAttribute("user");
    if(user==null)
    {
        user = new User();
    }
%>
<div class="card-body">
    <h3 class="card-title text-center p-4">Request Update Your Phone Number</h3>
    <div class="row g-3">
        <form action="UserOperation" method="post">
            <input type="hidden" name="operation" value="requestNewPhone">
            <div class="row pt-4 pb-4 border-top border-bottom">
                <div class="col-sm-12">
                    <div class="row pb-4">
                        <div class="col-sm-4 text-end">
                            <label class="col-form-label">Your Current Phone:</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="oldPhone" id="oldPhone" value=<%=user.getPhoneNumber()%> readonly>
                        </div>
                    </div>
                    <div class="row pb-4">
                        <div class="col-sm-4 text-end">
                            <label class="col-form-label">New Email:</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="phone" id="phone" required>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row pt-4">
                <div class="col-sm-11 text-end">
                    <input type="submit" class="btn btn-primary mb-3 btn-lg py-1 px-5 ms-4" value="Send Request">
                </div>
            </div>
        </form>
    </div>
</div>


