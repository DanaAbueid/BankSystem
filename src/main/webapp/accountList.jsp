<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="java.util.List" %>
<%@ page import="model.CustomerAccount" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Account List</title>
</head>
<body>
    <section class="container mt-4">
        <h2 class="mb-4">Account List</h2>

        <table class="table table-striped">
            <thead class="table-dark">
                <tr>
                    <th>Account Number</th>
                    <th>Balance</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% 
                List<CustomerAccount> accList = (List<CustomerAccount>) request.getAttribute("CustomerAccounts");
                if (accList != null) {
                    for (CustomerAccount customerAccount : accList) {
                %>
                    <tr>
                        <td><%= customerAccount.getAccountNumber() %></td>
                        <td><%= customerAccount.getMinimumBalance() %></td>
                        <td>
                            <a href="AccountDetailsServlet?id=<%= customerAccount.getAccountNumber() %>" class="btn btn-info">View Details</a>
                        </td>
                    </tr>
                <% 
                    }
                } else { 
                %>
                    <tr>
                        <td colspan="3" class="text-center">No Accounts found.</td>
                    </tr>
                <% } %>
            </tbody>
        </table>

        <div class="mt-3">
            <form action="AddAccountServlet" method="get">
              <input type="hidden" name="id" value="<%= request.getAttribute("id") %>">
				<input type="submit" class="btn btn-success" value="Add New Account">
            </form>
        </div>
    </section>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-7Fq4lL7SfdX3+qSmVoD2Huj17M8n8ZqE/2hcRLSY3vSkHhgho6GZ/YzRhqEUOF4b" crossorigin="anonymous"></script>
</body>
</html>
