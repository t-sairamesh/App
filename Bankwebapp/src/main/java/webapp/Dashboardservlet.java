package webapp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;


@WebServlet("/Dashboardservlet")
public class Dashboardservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    
    public Dashboardservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession  session = request.getSession();
		end_user sessionUser = (end_user)session.getAttribute("user");
		if(sessionUser != null) {
			response.setContentType("text/html");  
			request.setAttribute("email", sessionUser);
			RequestDispatcher rd =  request.getRequestDispatcher("/dashboard.jsp");
			rd.forward(request, response);
		}else {
			response.setContentType("text/html");  
			response.getWriter().write("Invalid Credentials Please Register");
			RequestDispatcher rd =  request.getRequestDispatcher("/signin.jsp");
			rd.include(request, response);
		}
		
		
	}
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
