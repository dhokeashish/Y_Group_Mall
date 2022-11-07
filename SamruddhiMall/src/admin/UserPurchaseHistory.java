package com.admin_module;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserPurchaseHistory {
	
	static PreparedStatement pst = null;
	// establishing JDBC Connectivity
	static Connection connection = Utilities.getConnection();
	
	public static void purchaseHistory() {
		
		System.out.println(" :: User Purchase history Records ::");
		
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter User ID to diplay Purchase History ");
		int userID = sc.nextInt();
		
		//sql querry>> "create view userhistory as (select userid,shopping_order.order_id,order_date,SHIPPING_ADDRESS from shopping_Order inner join order_listON shopping_Order.order_id=order_list.order_id);";
		
		String userhistory = "select * from userhistory where userid=?;";
		
		try {
			pst = connection.prepareStatement(userhistory);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pst.setInt(1, userID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//SQL Query executed
		try {
			boolean iscounted = pst.execute();
			if (iscounted == true)
				System.out.println("Querry executed ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//Iterate resultset to get user purchase history 
		try {
			ResultSet rs = pst.executeQuery(userhistory);
			System.out.println(" :: User Purchase history for userid "+ userID +" ::");
			while (rs.next()) {System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "
					+" "+rs.getString(4));}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
