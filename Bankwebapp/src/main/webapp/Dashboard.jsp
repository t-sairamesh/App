<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "webapp.end_user" %> 
<%@page import = "webapp.BankAccounts" %>  
<%@page import = "java.util.List" %>  

  

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<center>
<title>Dashboard</title>
</head>
<body>



		<h3>BANKING WEB APPLICATION </h3>
		<% List<BankAccounts> bankList = (List<BankAccounts>)request.getAttribute("bankList"); %>
		
		
		<table>
			<tr>
				<td>
					<h3>Welcome <%=((end_user)request.getAttribute("user")).getLastName() %> </h3>
				</td>
				
				<td align="right">
					<form action = "http://localhost:8082/Bankwebapp/Signoutservlet" method = "post">
					   
						<input type="submit" value="Logout"/>
						
					</form>
				</td>
			</tr>
			</table>
			
			<table >
			
	
		<tr><td>Primary account Number : <% ((BankAccounts)request.getAttribute("bankList1")).getBankNumber(); %> </td> </tr>
		<tr><td>Account Balance : <%((BankAccounts)request.getAttribute("bankList1")).getCurrBal(); %> </td></tr>   <tr><td> <form action="" method="post"> <input type="submit" value="[+]"> </form></td></tr> 
		
		    
				<tr>
				<%for(int i=0;i<bankList.size();i++){
					BankAccounts ba = bankList.get(i);
				%>
					<td>
						BANK NAME: <%=ba.getBankName() %></br>
						BANK Acct No: <%=ba.getBankNumber() %></br>
						IFSC CODE: <%=ba.getIfsccode() %></br>
						Current Balance :<%=ba.getCurrBal() %>
						
					</td>
				<%} %>
					<td>
					<form action = "" method = "">
					<input type = "submit" value = "Add Bank Account">
					</form>
					
					</td>
				</tr>
			</table>
		
	
	
</body>
</html>
		
		
</center>
</body>
</html>