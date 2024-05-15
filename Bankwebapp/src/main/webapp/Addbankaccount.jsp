<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Bank Account</title>
</head>
<body>

<form action="AddbankServlet" method="post">
<h1>Add BankAccount  </h1>
<table>
<tr>
         <td><label>Email</label></td>
         <td><input type="text" name="email"></td>
    </tr>  
 <tr>
<tr>
         <td><label>End_userId :</label></td>
         <td><input type="text" name="end_userId"></td>
    </tr>  
 <tr>
         <td><label>Bank Name :</label></td>
         <td><input type="text" name="bankname"></td>
    </tr>  
     <tr>
         <td><label>Bank Account Number :</label></td>
         <td><input type="text" name="bankaccnum"></td>
    </tr>  
     <tr>
         <td><label>Account Type :</label></td>
         <td><input type="text" name="acctype"></td>
    </tr>  
     <tr>
         <td><label>IFSC Code :</label></td>
         <td><input type="text" name="ifsccode"></td>
    </tr>  
     <tr>
         <td><label>Current Balance :</label></td>
         <td><input type="text" name="currbal"></td>
    </tr>  
    
     <tr>
         <td><label>Pin :</label></td>
         <td><input type="text" name="pin"></td>
    </tr>  
     <tr>
         <td><label></label></td>
         <td><input type="submit" ></td>
    </tr>  

</table>
</form>

</body>
</html>