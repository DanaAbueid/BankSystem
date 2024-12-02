<%@ page import="java.util.List" %>
<%@ page import="model.*" %>
<%@ page import="dao.*" %>
<%
    List<Relation> relations = (List<Relation>) request.getAttribute("relations");
    List<AccountType> accountTypes = (List<AccountType>) request.getAttribute("AccountTypes");
    CustomerAccount account = (CustomerAccount) request.getAttribute("account");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Customer Account</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">Update Customer Account</h2>
        <div class="card">
            <div class="card-body">
                <form action="AccountDetailsServlet" method="post">
                    <!-- CIF ID -->
                    <div class="mb-3">
                        <label for="cif_id" class="form-label">CIF ID:</label>
                        <input type="hidden" id = "cif_id" name="cif_id" value="<%= account.getCifId() %>">
                        <input type="text" class="form-control" value="<%= account.getCifId() %>" disabled>
                    </div>
                        <input type="hidden" id = "id" name="id" value="<%= account.getAccountNumber()%>"> 

                    <!-- Customer Name -->
                    <div class="mb-3">
                        <label for="customer_name" class="form-label">Customer Name:</label>
                        <input type="text"  id = "customer_name" name = "customer_name" class="form-control" value="<%= account.getCustomerName() %>" >
                    </div>

                    <!-- Minimum Balance -->
                    <div class="mb-3">
                        <label for="minimum_balance" class="form-label">Minimum Balance:</label>
                        <input type="number" name="minimum_balance" id="minimum_balance" 
                               value="<%= account.getMinimumBalance() %>" class="form-control" required>
                    </div>

                    <!-- Nominee -->
                    <div class="mb-3">
                        <label for="nominee" class="form-label">Nominee:</label>
                        <input type="text" name="nominee" id="nominee" 
                               value="<%= account.getNominee() != null ? account.getNominee() : "" %>" class="form-control">
                    </div>

                    <!-- Account Type -->
                    <div class="form-group mt-3">
                        <label for="account_type">Account Type:</label>
                        <select name="account_type" id="account_type" class="form-control" required>
                            <% for (AccountType type : accountTypes) { %>
                                <option value="<%= type.getTypeId() %>" 
                                    <%= account.getAccountTypeId() == type.getTypeId() ? "selected" : "" %>>
                                    <%= type.getTypeName() + " - " + type.getSubTypeName() %>
                                </option>
                            <% } %>
                        </select>
                    </div>

                    <!-- Relation -->
                    <div class="form-group mt-3">
                        <label for="relation">Relation:</label>
                        <select name="relation" id="relation" class="form-control" required>
                            <% for (Relation relation : relations) { %>
                                <option value="<%= relation.getRelationId() %>" 
                <%= String.valueOf(relation.getRelationId()).equals(account.getRelationship()) ? "selected" : "" %>>
                                    <%= relation.getRelationName() %>
                                </option>
                            <% } %>
                        </select>
                    </div>

                    <!-- Submit Button -->
                    <div class="mt-4">
                        <button type="submit" class="btn btn-primary">Update Account</button>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#confirmationModal">delete</button>
                    </div>
                </form>
            </div>
 
<!-- Confirmation Modal -->
<div class="modal fade" id="confirmationModal" tabindex="-1" aria-labelledby="confirmationModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content rounded-3 shadow">
            <div class="modal-body p-4 text-center">
                <h5 class="mb-0">Are you sure you want to delete this account?</h5>
                <p class="mb-0">This action cannot be undone.</p>
            </div>
            <div class="modal-footer flex-nowrap p-0">
                <form action="AccountDetailsServlet" method="post">
                    <input type="hidden" name="ids" value="<%= account.getAccountNumber() %>">
                  
                   <input type="hidden" name="cif_ids" value="<%= account.getCifId() %>">
                  <div class="modal-footer flex-nowrap p-0">
                    <input type="submit" name="delete" value="Delete" class="btn btn-lg btn-link fs-6 text-decoration-none col-6 py-3 m-0 rounded-0 border-end">
					<input type="button" class="btn btn-lg btn-link fs-6 text-decoration-none col-6 py-3 m-0 rounded-0" data-bs-dismiss="modal">
					</div>
					
                </form>
            </div>
        </div>
    </div>
</div>

        </div>
    </div>
    
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

