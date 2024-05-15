package webapp;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Signupservlet")
public class Signupservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Signupservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String fname = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String phNo = request.getParameter("phone");
		String dob = request.getParameter("date");
		String address = request.getParameter("text");
		String password = request.getParameter("password");
		BankwebappDAO dao = new BankwebappDAO();
		
		if(dao.isenduserexistwithPhNo(phNo)) {
			response.setContentType("text/html");  
			response.getWriter().write("User Account Exists with Phone Number:"+phNo+".Please try with another Phone Numeber");
			RequestDispatcher rd =  request.getRequestDispatcher("/signup.jsp");
			rd.include(request, response);
		}else {
			end_user user = new end_user();
			user.setFirstName(fname);
			user.setLastName(lName);
			user.setPhNo(Long.parseLong(phNo));
		
            user.setDob(dob);
			user.setEmail(email);
			user.setAddress(address);
			user.setPassword(password);
			
            dao.insertUser(user);
			
			RequestDispatcher rd =  request.getRequestDispatcher("/Signin.jsp");
			rd.forward(request, response);
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
