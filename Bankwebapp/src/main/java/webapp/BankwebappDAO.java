package webapp;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import webapp.BankAccounts;
import webapp.end_user;



public class BankwebappDAO {
	public boolean validuser(String Email, String Password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankwebapp","root","Sairamesh@19");
			Statement stmt = con.createStatement();
			String query = "select * from end_user where Email='"+Email+"' and PassWord='"+Password+"'";
			//System.out.println(query);
			
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				return true;
			}
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public  boolean insertUser(end_user user) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankwebapp","root","Sairamesh@19");				
			Statement stmt = con.createStatement();
			String query = "insert into end_user(FirstName,LastName,PhoneNo,DateOfBirth,Email,Address,Password)\r\n"
					+ "values('"+user.getFirstName()+"','" +user.getLastName()+"','"+user.getPhNo()+"','"+user.getDob()+"','"+user.getEmail()+"','"+user.getAddress()+"','"+user.getPassword()+"')";
					
			//System.out.println(query);
			stmt.executeUpdate(query);
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean isenduserexistwithPhNo(String PhNo){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankwebapp","root","Sairamesh@19");				
			Statement stmt = con.createStatement();
			String query = "select * from end_user  where PhoneNo='"+PhNo+"'";
			//System.out.println(query);
			ResultSet rs= stmt.executeQuery(query);
			if(rs.next()) {
				return true;
			}
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
		
	}
	public end_user getUserByEmail(String Email) {
		end_user user = new end_user();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankwebapp","root","Sairamesh@19");
			Statement stmt = con.createStatement();
			String query = "select * from end_user where Email='"+Email+"'";
			System.out.println(query);
			ResultSet rs= stmt.executeQuery(query);
			if(rs.next()) {
				String fname = rs.getString("FirstName");
				String lname = rs.getString("LastName");
				String phno = rs.getString("PhoneNo");
				int userId = rs.getInt("End_userid");
				//double currWallBalance = rs.getDouble("CurrWalletBal");
				
				user.setFirstName(fname);
				user.setLastName(lname);
				//user.setCurrWallBalance(currWallBalance);
				user.setPhNo(Long.parseLong(phno));
				user.setEnd_userId(userId);
			}
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return user;
		
	}
	public List<BankAccounts> getBADetailsByEnd_userId(int End_userId){
		List<BankAccounts> bankList = new ArrayList<BankAccounts>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankwebapp","root","Sairamesh@19");
			Statement stmt = con.createStatement();
			String query = "select * from bankaccounts where End_userId = '"+End_userId+"'";
			System.out.println(query);
			ResultSet rs= stmt.executeQuery(query);
			while(rs.next()) {
				BankAccounts ba = new BankAccounts();
				String bankNumber = rs.getString("Bankaccountno");
				String bankName = rs.getString("Bankname");
				String ifscCode = rs.getString("Bankifscode");
				String accType = rs.getString("accounttypeId");
				int End_userid = rs.getInt("End_userId");
				double currbankbal = rs.getDouble("CurrBankAcctBalance");
				
				
			  ba.setAcctypeId(accType);
			  ba.setBankNumber(bankNumber);
			  ba.setBankName(bankName);
			  ba.setIfsccode(ifscCode);
			  ba.setEnd_userId(End_userid);
			  ba.setCurrBal(currbankbal);
			  bankList.add(ba);
				
			}
		con.close();
	}catch(Exception ex) {
		ex.printStackTrace();
		return null;
	}
	return bankList;
	
}
	
	public BankAccounts getBADetailsByEnd_userIdinfo(int End_userId){
		
		BankAccounts bas = new BankAccounts();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankwebapp","root","Sairamesh@19");
			Statement stmt = con.createStatement();
			String query = "select * from bankaccounts where End_userId = '"+End_userId+"'";
			System.out.println(query);
			ResultSet rs= stmt.executeQuery(query);
			if(rs.next()) {
				
				String bankNumber = rs.getString("Bankaccountno");
				String bankName = rs.getString("Bankname");
				String ifscCode = rs.getString("Bankifscode");
				String accType = rs.getString("accounttypeId");
				int End_userid = rs.getInt("End_userId");
				double currbankbal = rs.getDouble("CurrBankAcctBalance");
				
				
				bas.setAcctypeId(accType);
				bas.setBankNumber(bankNumber);
				bas.setBankName(bankName);
				bas.setIfsccode(ifscCode);
				bas.setEnd_userId(End_userid);
				bas.setCurrBal(currbankbal);
				
			}
		con.close();
	}catch(Exception ex) {
		ex.printStackTrace();
		return null;
	}
	return bas;
	
}
	public boolean validemail(String Email) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankwebapp","root","Sairamesh@19");
			Statement stmt = con.createStatement();
			String query = "select * from end_user where Email='"+Email+"'";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				return true;
			}
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
		return false;
	}

	public boolean insertBankdetails(BankAccounts Ba) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankwebapp","root","Sairamesh@19");
			Statement stmt = con.createStatement();
			String query = "insert into BankAccounts(BankAcctNo,BankName,AcctTypeId,BankIFSCCode,BankAcctPin,UserId,CurrBankAcctBalance) values('"+bankd.getBankAccnum()+"','"+bankd.getBankName()+"','"+bankd.getAcctypeId()+"','"+bankd.getBankIFSCcode()+"','"+bankd.getPin()+"','"+bankd.getUserId()+"','"+bankd.getCurrAccBal()+"')";
			stmt.execute(query);
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
		return false;


	}

