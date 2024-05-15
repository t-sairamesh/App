package webapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webapp.BankwebappDAO;
import webapp.BankAccounts;


@WebServlet("/AddbankServlet")
public class AddbankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddbankServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // TODO Auto-generated method stub
		   BankwebappDAO  dao = new BankwebappDAO();
		   String Email = request.getParameter("email");
		   String End_userid = request.getParameter("end_userId");
		   String Bankname = request.getParameter("bankname");
		   String Bankacctnumber = request.getParameter("bankaccnum");
		   String Acctype = request.getParameter("acctype");
		   String ifsccode = request.getParameter("ifsccode");
		   String Currbalance = request.getParameter("currbal");
		   String pin = request.getParameter("pin");
		   
		   if (dao.validemail(Email)) {
			   BankAccounts ba = new BankAccounts();
			   ba.setAcctypeId(Integer.parseInt(Acctype));
			   ba.setBankName(Bankname);
			   ba.setBankNumber(Bankacctnumber);
			   ba.setCurrBal(Double.parseDouble(Currbalance));
			   ba.setEnd_userId(Integer.parseInt(End_userid));
			   ba.setIfsccode(ifsccode);
			   ba.setPin(Integer.parseInt(pin));
		   }
		   
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
