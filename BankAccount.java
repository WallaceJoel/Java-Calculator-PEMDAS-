import java.util.Scanner;

public class BankAccount {

private String userName;
private String address;
private int accNum;
private double balance = 0;

public BankAccount(String n, String a, int x) {
	userName = n;
	address = a;
	accNum = x;
}

public void deposit(double x) {
	balance += x;
}
public void withdraw(double x) {
	if(balance > 0 && x <= balance) {
		balance -= x;
	}else {
		System.out.print("Can't withdraw balance is 0 or less than 0: Balance = " + balance);
		
	}
}
public double getBalance() {
	return balance;
}
public void setAddress(String x) {
	address = x;
}
public int getAccountNumber() {
	return accNum;
}
 
public String PrintAccountInfo() {
	char newline = '\n';
	return "Name is: " + userName +newline + "Address is: " + address + newline +"Account Number is: " + accNum + newline + "Your Balance is: " + balance;
}

public static void main(String[] args) {
	char newline = '\n';
	Scanner a = new Scanner(System.in);
	System.out.println("What's the name of the account holder?" + newline);
	String name = a.nextLine();
	System.out.println("What's the address of the account holder's address");
	String address = a.nextLine();
	
	BankAccount BA = new BankAccount(name, address, 253400029);
	
	boolean done= false;
	while(done != true) {
		System.out.println("Here is your balance: " + BA.getBalance());
		
		System.out.println("What would you like to do? Type [1] to deposit, [2] to withdraw, [3] to change address, [4] to get account number, [5] to print bank info, [0] to end");
		Scanner b = new Scanner(System.in);
		
		int x = Integer.parseInt(b.nextLine());
		switch(x) {
		case 0:
			done = true; 
			break;
	
		case 1:
			System.out.println("How much would you like to deposit?");
			BA.deposit(Double.parseDouble(b.nextLine()));
			continue;
		case 2:
			System.out.println("How much would you like to withdraw?");
			BA.withdraw(Double.parseDouble(b.nextLine()));
			continue;
	
		case 3:
			System.out.println("What's your new address?");
			BA.setAddress(b.nextLine());
		
		case 4: 
			System.out.println("Here is your account number: " + BA.accNum);
			
		case 5:
			System.out.println(BA.PrintAccountInfo());
		}
		
		
		
		
		}
		
		
	}
	
}


