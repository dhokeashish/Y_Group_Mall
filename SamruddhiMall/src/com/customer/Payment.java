package com.customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

import com.shopconnector.ShopSQLConnection;

public class Payment
{

	ShopSQLConnection sscon=null;
	Scanner sc=new Scanner(System.in);
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null,rs2=null,rs3=null;
	public void makePayment(int custId, float total)
	{
		try
		{
			float balance=0;
		System.out.println("Enter your account number");
		int accno=sc.nextInt();
		System.out.println("Enter your account password");
		String pass=sc.next();	
		System.out.println("Enter your Shipping address");
		String adderss=sc.nextLine();	
		con=sscon.getShopConnection();
		stmt=con.createStatement();			
		rs=stmt.executeQuery("select * from bank where payment_bank_account_no="+accno+"and  password='"+pass+"'");
		if(rs.next())
		{
			balance=rs.getInt(3);
			balance=balance-total;
			stmt.executeUpdate("update bank set bank_balance=10000 where payment_bank_account_no="+accno+" and  password='"+pass+"'");
			
			System.out.println("Your payment is done succesfully!!!!!!");
			updateOrder(custId,total,adderss);
			
		}
		else {
			System.out.println("Enter correct account number and password.");
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	private void updateOrder(int custId, float total,String adderss) 
	{
		try
		{
			
			int pcount=1;
			con=sscon.getShopConnection();
			stmt=con.createStatement();			
			rs=stmt.executeQuery("select * from shopping_cart where userid="+custId);
			stmt.executeUpdate("insert into shopping_order( userid,ORDER_DATE,SHIPPING_ADDRESS,orderTotal) values("+custId+","+new Date()+",'"+adderss+"',"+total+") ");
			rs3=stmt.executeQuery("select Order_ID from shopping_order ORDER BY  Order_ID DESC LIMIT 1");
			rs3.next();
			int order_id=rs3.getInt(1);
			while(rs.next())
			{
				rs2=stmt.executeQuery("insert into order_list values("+order_id+","+rs.getInt(2)+",1)");
											
			}
			stmt.executeUpdate("delete from shopping_cart where userid="+custId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	

}
