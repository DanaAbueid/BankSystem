package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerAccountDao;
import model.CustomerAccount;

@WebServlet("/CustomerListServlet")
public class CustomerListServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    
    // Instance of the DAO to interact with the database
    private CustomerAccountDao customerAccountDao = new CustomerAccountDao();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Fetch the list of customers using the DAO method
    	
        List<CustomerAccount> customers = customerAccountDao.getAllCustomers();
    // Set the list of customers as a request attribute
        request.setAttribute("CustomerList", customers);
        
    // Forward the request to the JSP for rendering
        request.getRequestDispatcher("customerList.jsp").forward(request, response);
    }
}
