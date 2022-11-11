package com.customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import com.header.AllHeader;
import com.shopconnector.ShopSQLConnection;
import com.shopping.ShowList;

public class Bill 
{
	ShopSQLConnection sscon=null;
	Scanner sc=new Scanner(System.in);
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null,rs2=null;
	
	public void showBill(int custId) 
	{
		AllHeader h1=new AllHeader();
		h1.addHeader();
	
		try 
		{
			int pcount=1;
			con=sscon.getShopConnection();
			stmt=con.createStatement();			
			rs=stmt.executeQuery("select * from shopping_cart where userid="+custId);
			rs2=stmt.executeQuery("select name from customer where userid="+custId);
			System.out.println("!!!!!!!!Shopping Bill!!!!!!!!!");
			if(rs.next())
			System.out.println("Customer Name : "+rs2.getString(3));
			
			System.out.println("Date : "+new Date());
			System.out.println("Products you are purchasing are:");
			float total=0.0f;
			while(rs.next())
			{
				rs2=stmt.executeQuery("select * from product where pid="+rs.getInt(2));
				System.out.println(pcount+": "+rs2.getString(2)+"\tPrice"+rs2.getFloat(6));
				total=total+rs2.getFloat(6);
				pcount++;							
			}	
			System.out.println("Grand total is:"+total);
			System.out.println("Select 1 if you want to make payment\n2 if you want to add more products\n3: If you want to logout.");
			int pindex=sc.nextInt();
			if(pindex==1)
			{
				Payment p=new Payment();
				p.makePayment(custId,total);
			}
			else if(pindex==2)
			{
				ShowList ob=new ShowList ();
				ob.showList(custId);
			}
			else if(pindex==3)
			{
				System.exit(0);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
}
