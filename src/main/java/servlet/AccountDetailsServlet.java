package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.AccountTypeDao;
import dao.CustomerAccountDao;
import dao.RelationDao;
import model.AccountType;
import model.CustomerAccount;
import model.Relation;
@WebServlet("/AccountDetailsServlet")
public class AccountDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountTypeDao accountTypeDao = new AccountTypeDao();
        RelationDao relationDao = new RelationDao();
        CustomerAccountDao customerAccountDao = new CustomerAccountDao();

        String accountId = request.getParameter("id"); // Account Number (ID)
        CustomerAccount account = customerAccountDao.getCustomerAccount(accountId);

        List<AccountType> accountTypes = accountTypeDao.getAllAccountTypes();
        List<Relation> relations = relationDao.getAllRelation();

        request.setAttribute("account", account);
        System.out.println(account);
        request.setAttribute("AccountTypes", accountTypes);
        request.setAttribute("relations", relations);

        request.getRequestDispatcher("accountDetails.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deleteParam = request.getParameter("delete");
        
        String accountId = request.getParameter("id"); // Account Number (ID)
        String cifId = request.getParameter("cif_id"); // Used for redirection
        String accountId2 = request.getParameter("ids"); // Account Number (ID)
        
        String cifId2 = request.getParameter("cif_ids"); // Used for redirection

        CustomerAccountDao dao = new CustomerAccountDao();

        if (deleteParam != null ) {
            System.out.println(accountId2);
            System.out.println(cifId2);
            dao.deleteCustomerAccount(accountId2);
            response.sendRedirect("AccountListServlet?id=" + cifId2); // Redirect to the account list for the CIF
            return;
        }else {

        // If not deleting, update the account
        String customerName = request.getParameter("customer_name");
        String accountTypeIdStr = request.getParameter("account_type");
        String minimumBalanceStr = request.getParameter("minimum_balance");
        String nominee = request.getParameter("nominee");
        String relation = request.getParameter("relation");
        int accountTypeId = Integer.parseInt(accountTypeIdStr);
        double minimumBalance = Double.parseDouble(minimumBalanceStr);

        CustomerAccount customerAccount = new CustomerAccount();
        customerAccount.setCifId(cifId);
        customerAccount.setCustomerName(customerName);
        customerAccount.setAccountNumber(accountId);
        customerAccount.setAccountTypeId(accountTypeId);
        customerAccount.setMinimumBalance(minimumBalance);
        customerAccount.setNominee(nominee);
        customerAccount.setRelationship(relation);
        customerAccount.setDeleted(false);
System.out.println(customerAccount);
        dao.updateCustomerAccount(customerAccount);

        // Redirect to account list after update
        response.sendRedirect("AccountListServlet?id=" + cifId);
    }}
}
