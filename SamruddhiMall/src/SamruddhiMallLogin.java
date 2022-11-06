import java.util.Scanner;

import admin.Admin;
import customer.CustomerModule;
import header.AllHeader;
import footer.AllFooter;

public class SamruddhiMallLogin {
	
	
		
		
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		AllHeader h1=new AllHeader();
		h1.addHeader();
		System.out.println("Select 1 to start the Admin Module\n2 to start Customer Moldule: \n\n\n\n");
		
		int option=sc.nextInt();
		if(option==1)
			new Admin();
		else 
		{
			CustomerModule cm=new CustomerModule();
			cm.showCustomerModule();
		}		
	}
}
