<%@ page import="java.util.List" %>
<%@ page import="model.*" %>
<%@ page import="dao.*" %>
<%
    List<Relation> relations = (List<Relation>) request.getAttribute("relations");
    List<AccountType> AccountTypes = (List<AccountType>) request.getAttribute("AccountTypes");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Customer Account</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">Add Customer Account</h2>
        <div class="card">
            <div class="card-body">
                <form action="AddAccountServlet" method="post">
                    <!-- CIF ID -->
                    <div class="mb-3">
                        <label for="cif_id" class="form-label">CIF ID:</label>
                            <input type="hidden" name="id" value="<%= request.getAttribute("id") %>">
                        <input type="text" value = "<%= request.getAttribute("id") %>"  class="form-control" required>
                    </div>

                    <!-- Account Number 
                    <div class="mb-3">
                        <label for="account_number" class="form-label">Account Number:</label>
                        <input type="text" name="account_number" class="form-control" required>
                    </div>
-->
           <div class="mb-3">
    <input type="hidden" name="customer_name" value="<%= request.getAttribute("name") != null ? request.getAttribute("name") : "" %>">
    <label for="customer_name" class="form-label">Customer Name:</label>
    <input type="text" value="<%= request.getAttribute("name") != null ? request.getAttribute("name") : "Name not found" %>" class="form-control" >
</div>



                    <!-- Minimum Balance -->
                    <div class="mb-3">
                        <label for="minimum_balance" class="form-label">Minimum Balance:</label>
                        <input type="number" name="minimum_balance" class="form-control" required>
                    </div>

                    <!-- Nominee -->
                    <div class="mb-3">
                        <label for="nominee" class="form-label">Nominee:</label>
                        <input type="text" name="nominee" class="form-control">
                    </div>
                    <!-- Relation -->
                    <div class="form-group mt-3">
                        <label for="AccountType">Account Type:</label>
                        <select id="AccountType" name="AccountType" class="form-control" required>
                            <%
                            for (AccountType type : AccountTypes) {
                            %>
                                 <option value="<%= type.getTypeId() %>">
                                    <% type.getTypeName(); %>   <% type.getSubTypeName();%>  
                                </option>
                            <% } %>
                        </select>
                    </div>

                    <!-- Relation -->
                    <div class="form-group mt-3">
                        <label for="relation">Relation:</label>
                        <select id="relation" name="relation" class="form-control" required>
                            <%
                                for (Relation relation : relations) {
                            %>
                                <option value="<%= relation.getRelationId() %>">
                                    <%= relation.getRelationName() %>
                                </option>
                            <% } %>
                        </select>
                    </div>

                    <!-- Submit Button -->
                    <div class="mt-4">
                        <button type="submit" class="btn btn-primary">Add Customer Account</button>
      <input type="hidden" name="id" value="<%= request.getAttribute("id") %>">
                  
                        <a href="AccountListServlet?id=<%= request.getAttribute("id") %>" class="btn btn-secondary">Cancel</a>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

