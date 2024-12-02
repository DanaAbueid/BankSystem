package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerAccountDao;
import model.CustomerAccount;

import java.util.List;

@WebServlet("/AccountListServlet")
public class AccountListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Instance of CustomerAccountDao to interact with the database
    private CustomerAccountDao customerAccountDao = new CustomerAccountDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the cifId parameter from the request
        String cifId = request.getParameter("id");
        request.setAttribute("id", cifId);
        // Fetch customer accounts based on the cifId
        List<CustomerAccount> customerAccounts = customerAccountDao.getAccountsByCifId(cifId);
      
        // Set the list of customer accounts as a request attribute
        request.setAttribute("CustomerAccounts", customerAccounts);

        // Forward the request to the JSP for rendering
        request.getRequestDispatcher("accountList.jsp").forward(request, response);
    }
}
