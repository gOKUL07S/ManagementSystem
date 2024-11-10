package Project.ManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;


public class App {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DatabaseManager manager = new DatabaseManager();
		
		// create initial accounts
		System.out.print("How many number of customers do you want to input? ");
		int n = sc.nextInt();
//        Account C[] = new Account[n]; 
//		ArrayList<Account> accounts = new ArrayList<Account>();
		ArrayList<Account> accounts = manager.FetchAllAccounts();
//        for (int i = 0; i < C.length; i++) {  
//            C[i] = new Account();  
//            C[i].openAccount();  
//        }  
//        
		for (int i = 0; i < n; i++) {
			accounts.add(new Account());
			accounts.get(i).openAccount();
		}
		// loop runs until number 5 is not pressed to exit
		int ch;
		do {
			System.out.println("\n ***Banking System Application***");
			System.out.println(
					"1. Display all account details \n 2. Search by Account number\n 3. Deposit the amount \n 4. Withdraw the amount \n 5.Exit ");
			System.out.println("Enter your choice: ");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
//                        for (int i = 0; i < C.length; i++) {  
////                            C[i].showAccount();  
//                        }  
				for (Account acc : accounts) {
					acc.showAccount();
				}
//                    	accounts.forEach(acc -> acc.showAccount());
				break;
			case 2:
				System.out.print("Enter account no. you want to search: ");
				long ac_no = sc.nextLong();
				boolean found = false;
//                        for (int i = 0; i < C.length; i++) {  
//                            found = C[i].search(ac_no);  
//                            if (found) {  
//                                break;  
//                            }  
//                        }  
				for (Account acc : accounts) {
					found = acc.search(ac_no);
					if (found) {
						break;
					}
				}
				if (!found) {
					System.out.println("Search failed! Account doesn't exist..!!");
				}
				break;
			case 3:
				System.out.print("Enter Account no. : ");
				ac_no = sc.nextLong();
				found = false;
//                        for (int i = 0; i < C.length; i++) {  
//                            found = C[i].search(ac_no);  
//                            if (found) {  
//                                C[i].deposit();  
//                                break;  
//                            }  
//                        }  
				for (Account acc : accounts) {
					found = acc.search(ac_no);
					if (found) {
						acc.deposit();
						break;
					}
				}
				if (!found) {
					System.out.println("Search failed! Account doesn't exist..!!");
				}
				break;
			case 4:
				System.out.print("Enter Account No : ");
				ac_no = sc.nextLong();
				found = false;
//                        for (int i = 0; i < C.length; i++) {  
//                            found = C[i].search(ac_no);  
//                            if (found) {  
//                                C[i].withdrawal();  
//                                break;  
//                            }  
//                        }  
				for (Account acc : accounts) {
					found = acc.search(ac_no);
					if (found) {
						acc.withdrawal();
						break;
					}
				}
				if (!found) {
					System.out.println("Search failed! Account doesn't exist..!!");
				}
				break;
			case 5:
				for (Account acc : accounts) {
					manager.Save(acc);
				}
				System.out.println("See you soon...");
				break;
			}
		} while (ch != 5);
		sc.close();
	}

}
