package com.admin_module;

import java.util.Scanner;

public class Main_admin {
	public static void main(String[] args) {


		System.out.println("\n" + "   	::: welcome to Admin Account ::: ");

		System.out.println(" Press ");
		System.out.println(" [1] To add product" + "       " + " [2] To Update existing Product");
		System.out.println(" [3] To delete product" + "     " + "[4] To view product IN STOCK");
		System.out.println(" [5] To generate stock report");
		System.out.println(" [6] To see user purchase History ");

		Scanner sc = new Scanner(System.in);
		int Uinput = sc.nextInt();
		// add product
		if (Uinput == 1) {
			Product_update.addProduct();
		}
		//update product
		else if (Uinput == 2) {
			// update product name of given product id.
			System.out.println("Press");
			System.out.println(" [1] To update product name" + "   " + "[2] To update product ID ");
			int update = sc.nextInt();
			if (update == 1)
				Product_update.updateProduct_name();
			else if (update == 2)
				Product_update.updateProduct_id();
			else
				System.out.println("plese enter valid response");
		}
		//delete product
		else if (Uinput == 3) {
			//
			System.out.println("Press");
			System.out.println(" [1] To delete product( with name)" + "   " + "[2] To delete product (with ID) ");
			int delete = sc.nextInt();
			if (delete == 1)
				Product_update.deleteProduct_name();
			else if (delete == 2)
				Product_update.deleteProduct_id();
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
		else System.out.println("plese enter valid response");

	}
}
