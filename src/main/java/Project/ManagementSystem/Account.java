package Project.ManagementSystem;

import java.util.Scanner;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public final class Account {

	@Id
	private long accno; 
	private String name;  
    private AccountType acc_type;  
    private long balance;
    
    @Transient
    Scanner sc = new Scanner(System.in);  
    
    public long getAccno() {
		return accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name.length() > 0)
			this.name = name;
	}
	public AccountType getAcc_type() {
		return acc_type;
	}
	public long getBalance() {
		return balance;
	}

    //method to open new account  
    public void openAccount() {  
        System.out.print("Enter Account No: ");  
        accno = sc.nextLong();  
        System.out.print("Enter Account type: \n 1.Savings \t 2.Current");  
        acc_type = AccountType.values()[sc.nextInt()];  
        System.out.print("Enter Name: ");  
        name = sc.next();  
        System.out.print("Enter Balance: ");  
        balance = sc.nextLong();  
    }  
    //method to display account details  
    public void showAccount() {  
        System.out.println("Name of account holder: " + name);  
        System.out.println("Account no.: " + accno);  
        System.out.println("Account type: " + acc_type);  
        System.out.println("Balance: " + balance);  
    }  
    //method to deposit money  
    public void deposit() {  
        long amt;  
        System.out.println("Enter the amount you want to deposit: ");  
        amt = sc.nextLong();  
        balance = balance + amt;  
    }  
    //method to withdraw money  
    public void withdrawal() {  
        long amt;  
        System.out.println("Enter the amount you want to withdraw: ");  
        amt = sc.nextLong();  
        if (balance >= amt) {  
            balance = balance - amt;  
            System.out.println("Balance after withdrawal: " + balance);  
        } else {  
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!" );  
        }  
    }  
    //method to search an account number  
    public boolean search(long ac_no) {  
        if (accno == ac_no) {  
            showAccount();  
            return (true);  
        }  
        return (false);  
    } 
    
    @Override
	public String toString() {
		return "Account [accno=" + accno + ", name=" + name + ", acc_type=" + acc_type.toString() + ", balance=" + balance + "]";
	}
    
	public enum AccountType
    {
    	Savings,
    	Current
    }

}
