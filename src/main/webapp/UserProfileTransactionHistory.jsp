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
    List<Transaction> userTransactionList = new CustomerService().getUserTransaction(customer.getUserId());
%>
<div class="card-body" style="min-height: 600px;">
    <h3 class="card-title text-center p-4">Transaction History</h3>
    <div class="row g-3">
        <div class="table-responsive">
            <table class="table table-sm table-hover">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Date</th>
                    <th scope="col">From/TO</th>
                    <th scope="col">Detail</th>
                    <th scope="col">Bill</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for(int i = 0; i < userTransactionList.size(); i++)
                    {
                %>
                <tr>
                    <th><%=userTransactionList.get(i).getDate()%></th>
                    <td><%=userTransactionList.get(i).getObject()%></td>
                    <td><%=userTransactionList.get(i).getDetail()%></td>
                    <td><%=userTransactionList.get(i).getBill()%></td>
                </tr>
                <%
                    }
                %>

                </tbody>
            </table>
        </div>
    </div>
</div>


