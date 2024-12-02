package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.*;
import model.*;

@WebServlet("/AddAccountServlet")
public class AddAccountServlet extends HttpServlet  { 

	private static final long serialVersionUID = 1L;
	
	public String generateAccountNumber(String cifId) {
	    Random random = new Random();

	    StringBuilder accountNumber = new StringBuilder(cifId);

	    for (int i = 0; i < 8; i++) {
	        accountNumber.append(random.nextInt(10)); 
	    }
	    return accountNumber.toString();
	}

      
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch account types and relations for dropdowns
        AccountTypeDao accountTypeDao = new AccountTypeDao();
        CustomerAccountDao dao = new CustomerAccountDao();
        List<AccountType> accountTypes = accountTypeDao.getAllAccountTypes();
        RelationDao relationDao = new RelationDao();
        List<Relation> relations = relationDao.getAllRelation();
        String cifId = request.getParameter("id");
        String name = dao.getCustomerName(cifId);
        // 
        if (cifId == null) {
            System.out.println("Error: cifId is null in AddAccountServlet");
        } else {
            System.out.println("Received cifId: " + cifId);
        }

        request.setAttribute("id", cifId); // Pass along the cifId
        request.setAttribute("name", name); // Pass along the cifId

        System.out.println(accountTypes);
        
        // Set attributes to be accessed in the JSP
        request.setAttribute("AccountTypes", accountTypes);
        request.setAttribute("relations", relations);

        // Forward to the JSP page to show the form
        request.getRequestDispatcher("addAccount.jsp").forward(request, response);
    }
    
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Retrieve form parameters
    String cifId = request.getParameter("id");
    String customerName = request.getParameter("customer_name");
    int accountTypeId = Integer.parseInt(request.getParameter("AccountType"));
    double minimumBalance = Double.parseDouble(request.getParameter("minimum_balance"));
    String nominee = request.getParameter("nominee");
    String relationship = request.getParameter("relation");
    boolean isDeleted = false; // assuming new accounts are not deleted by default
    // Generate account number by appending 8 random digits to the cif_id
    String accountNumber = generateAccountNumber(cifId);

    // Create a CustomerAccount object
    CustomerAccount customerAccount = new CustomerAccount();
    customerAccount.setCifId(cifId);
    customerAccount.setAccountNumber(accountNumber); // Set generated account number
    customerAccount.setCustomerName(customerName);
    customerAccount.setAccountTypeId(accountTypeId);
    customerAccount.setMinimumBalance(minimumBalance);
    customerAccount.setNominee(nominee);
    customerAccount.setRelationship(relationship);
    customerAccount.setDeleted(isDeleted);

    // Insert the new customer account into the database
    CustomerAccountDao customerAccountDao = new CustomerAccountDao();
    customerAccountDao.addCustomerAccount(customerAccount);

    // Redirect to a success page or back to the account list
    response.sendRedirect("AccountListServlet?id="+cifId);
}

}