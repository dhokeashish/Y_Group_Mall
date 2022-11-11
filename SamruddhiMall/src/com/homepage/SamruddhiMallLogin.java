package com.homepage;
import java.util.Scanner;

import com.admin.Main_admin;
import com.customer.CustomerModule;
import com.footer.AllFooter;
import com.header.AllHeader;

public class SamruddhiMallLogin {
	
	
		
		
	public static void main(String[] args) {
		
	}

	public static void showMallHomePage() {
		Scanner sc=new Scanner(System.in);
		AllHeader h1=new AllHeader();
		h1.addHeader();
		while(true)
		{
			System.out.println("Select 1 to start the Admin Module\n2 to start Customer Moldule:\n3  to exit \n\n");
			int option=sc.nextInt();
			if(option==1) {
				 Main_admin o=new Main_admin();
				 o.adminModule();
			}
			else if(option==2)
			{
				CustomerModule cm=new CustomerModule();
				cm.showCustomerModule();
			}
			else if(option==3)
			{
				System.exit(0);
				
			}
			else
			{
				System.out.println("Please select correct option...");
			}
		}
		
	}
}
