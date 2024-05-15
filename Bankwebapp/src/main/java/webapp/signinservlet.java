package webapp;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/signinservlet")
public class signinservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public signinservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Email = request.getParameter("email");
		String Password = request.getParameter("password");
		BankwebappDAO dao = new BankwebappDAO();
		
		if(dao.validuser(Email, Password)) {
			end_user user = dao.getUserByEmail(Email);
			request.setAttribute("user", user);
			
			List<BankAccounts> bankList = dao.getBADetailsByEnd_userId(user.getEnd_userId());
			request.setAttribute("bankList", bankList);
			
			BankAccounts bankList1 = dao.getBADetailsByEnd_userIdinfo(user.getEnd_userId());
			request.setAttribute("bankList1", bankList1);
			
			RequestDispatcher rd =  request.getRequestDispatcher("/Dashboard.jsp");
			rd.forward(request, response);
		}else {
			response.setContentType("text/html");  
			response.getWriter().write("Invalid Credentials");
			RequestDispatcher rd =  request.getRequestDispatcher("/Signup.jsp");
			rd.include(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
