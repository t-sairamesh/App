package webapp;


public class BankAccounts {
	String BankNumber;
	String BankName;
	int AcctypeId;
	String ifsccode;
	int End_userId;
	double currBal;
	int pin;
	
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getBankNumber() {
		return BankNumber;
	}
	public void setBankNumber(String bankNumber) {
		BankNumber = bankNumber;
	}
	public String getBankName() {
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	public int getAcctypeId() {
		return AcctypeId;
	}
	public void setAcctypeId(int acctypeId) {
		AcctypeId = acctypeId;
	}
	public String getIfsccode() {
		return ifsccode;
	}
	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}
	public int getEnd_userId() {
		return End_userId;
	}
	public void setEnd_userId(int end_userId) {
		End_userId = end_userId;
	}
	public double getCurrBal() {
		return currBal;
	}
	public void setCurrBal(double currbalance) {
		this.currBal = currbalance;
	}
	

}
