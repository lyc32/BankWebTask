<%@ page import="com.example.bankwebtask.model.*" %>
<%@ page import="com.example.bankwebtask.severice.CustomerService" %>
<%@ page import="java.util.List" %>
<%
    HttpSession httpSession = request.getSession();
    Customer customer = (Customer)httpSession.getAttribute("user");
    if(customer ==null)
    {
        customer = new Customer();
    }
    List<UserRequest> userRequestList = new CustomerService().getUserRequest(customer.getUserId());
%>
<div class="card-body" style="min-height: 600px;">
    <h3 class="card-title text-center p-4">My Request</h3>
    <div class="row g-3">
        <div class="table-responsive">
            <table class="table table-sm table-hover">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Request Update</th>
                    <th scope="col">From</th>
                    <th scope="col">To</th>
                    <th scope="col">State</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for(int i = 0; i < userRequestList.size(); i++)
                    {
                %>
                <tr>
                    <th><%=userRequestList.get(i).getRequestId()%></th>
                    <td><%=userRequestList.get(i).getColumnName()%></td>
                    <td><%=userRequestList.get(i).getOldData()%></td>
                    <td><%=userRequestList.get(i).getNewData()%></td>
                    <td><%=userRequestList.get(i).getState()%></td>
                </tr>
                <%
                    }
                %>

                </tbody>
            </table>
        </div>
    </div>
</div>


