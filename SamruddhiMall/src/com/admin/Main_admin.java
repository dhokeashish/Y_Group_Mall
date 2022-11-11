package com.admin;

import java.util.Scanner;

import com.homepage.SamruddhiMallLogin;

public class Main_admin {

	public void adminModule() {
		System.out.println("\n" + "   	::: welcome to Admin Account ::: ");

		System.out.println(" Press ");
		System.out.println(" [1] To add product" + "       " + " [2] To Update existing Product");
		System.out.println(" [3] To delete product" + "     " + "[4] To view product IN STOCK");
		System.out.println(" [5] To generate stock report");
		System.out.println(" [6] To see user purchase History ");
		System.out.println(" [7] To go to home page ");
		System.out.println(" [8] To exit ");

		Scanner sc = new Scanner(System.in);
		int Uinput = sc.nextInt();
		// add product
		if (Uinput == 1) {
			ProductUpdate.addProduct();
		}
		//update product
		else if (Uinput == 2) {
			// update product name of given product id.
			System.out.println("Press");
			System.out.println(" [1] To update product name" + "   " + "[2] To update product ID ");
			int update = sc.nextInt();
			if (update == 1)
			{
				int pid=sc.nextInt();
				sc.nextLine();
				String pname=sc.next();
				ProductUpdate.updateProduct_name(pid,pname);
			}
			else if (update == 2)
			{
				int pid=sc.nextInt();
				sc.nextLine();
				String pname=sc.next();
				ProductUpdate.updateProduct_id(pname,pid);
			}
			else
				System.out.println("plese enter valid response");
		}
		//delete product
		else if (Uinput == 3) {
			//
			System.out.println("Press");
			System.out.println(" [1] To delete product( with name)" + "   " + "[2] To delete product (with ID) ");
			int delete = sc.nextInt();
			if (delete == 1) {
				String pname=sc.next();
				ProductUpdate.deleteProduct(pname);
			}
			else if (delete == 2)
			{
				int pid=sc.nextInt();
				sc.nextLine();
				ProductUpdate.deleteProduct(pid);
			}
			else
				System.out.println("plese enter valid response");
		} 
		//product in stock
		else if (Uinput == 4) {
			StockReport.productINStock();

		}
		//generate stock report
		else if (Uinput == 5) {
			StockReport.generateStockReport();

		}
		//user purchase History
		else if (Uinput == 6) {
			UserPurchaseHistory.purchaseHistory();
		}
		else if (Uinput == 7) {
			SamruddhiMallLogin.showMallHomePage();
		}
		else if (Uinput == 8) {
			System.exit(0);
		}
		else	
		
		System.out.println("plese enter valid response");
		
	}
}