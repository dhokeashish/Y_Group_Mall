package customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import ShopConnector.ShopSQLConnection;

public class Payment
{

	ShopSQLConnection sscon=null;
	Scanner sc=new Scanner(System.in);
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null,rs2=null;
	public void makePayment(int custId, float total)
	{
		try
		{
			float balance=0;
		System.out.println("Enter your account number");
		int accno=sc.nextInt();
		System.out.println("Enter your account password");
		String pass=sc.next();		
		con=sscon.getShopConnection();
		stmt=con.createStatement();			
		rs=stmt.executeQuery("select * from bank where payment_bank_account_no="+accno+"and  password='"+pass+"'");
		if(rs.next())
		{
			balance=rs.getInt(3);
			balance=balance-total;
			stmt.executeUpdate("update bank set bank_balance=10000 where payment_bank_account_no="+accno+" and  password='"+pass+"'");
			
			System.out.println("Your payment is done succesfully!!!!!!");
			updateOrder(custId);
			
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
	private void updateOrder(int custId) 
	{
		try
		{
			float total=0.0f;
			int pcount=1;
			con=sscon.getShopConnection();
			stmt=con.createStatement();			
			rs=stmt.executeQuery("select * from shopping_cart where userid="+custId);
			rs2=stmt.executeQuery("select name from customer where userid="+custId);
			
			while(rs.next())
			{
				rs2=stmt.executeQuery("select * from product where pid="+rs.getInt(2));
				//update order and order_list and empty cart
				//System.out.println(pcount+": "+rs2.getString(2)+"\tPrice"+rs2.getFloat(6));
				
				total=total+rs2.getFloat(6);
				pcount++;							
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	

}
