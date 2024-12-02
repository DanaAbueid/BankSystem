<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%> 
<%@ page import="java.util.List" %>
<%@ page import="model.CustomerAccount" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Customer List</title>
</head>
<body>
    <section class="container mt-4">
        <h2 class="mb-4">Customers List</h2>

        <table class="table table-striped">
            <thead class="table-dark">
                <tr>
                    <th>CIF ID</th>
                    <th>Customer Name</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% 
                List<CustomerAccount> customerList = (List<CustomerAccount>) request.getAttribute("CustomerList");
                if (customerList != null) {
                    for (CustomerAccount customer : customerList) { 
                %>
                    <tr>
                        <td><%= customer.getCifId() %></td>
                        <td><%= customer.getCustomerName() %></td>
                        <td>
                            <a href="AccountListServlet?id=<%= customer.getCifId() %>" class="btn btn-info">View Accounts</a>
                        </td>
                    </tr>
                <% 
                    }
                } else { 
                %>
                    <tr>
                        <td colspan="3" class="text-center">No Customer found.</td>
                    </tr>
                <% } %>
            </tbody>
        </table>

        <div class="mt-3">
            <form action="AddCustomerServlet" method="get">
                <input type="submit" class="btn btn-success" value="Add New Customer">
            </form>
        </div>
    </section>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-7Fq4lL7SfdX3+qSmVoD2Huj17M8n8ZqE/2hcRLSY3vSkHhgho6GZ/YzRhqEUOF4b" crossorigin="anonymous"></script>
</body>
</html>
