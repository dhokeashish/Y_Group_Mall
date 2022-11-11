package com.shopping;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.customer.Bill;
import com.header.AllHeader;
import com.shopconnector.ShopSQLConnection;

public class ShowList 
{
	ShopSQLConnection sscon=null;
	Scanner sc=new Scanner(System.in);
	LinkedList<Integer> ll=new LinkedList<Integer>();
	HashMap<String,Integer> hmap=new HashMap<String,Integer>(); 
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null,rs2=null;
	Bill bil;
	
	public ShowList()
	{
		sscon=new ShopSQLConnection();
		AllHeader h1=new AllHeader();
		h1.addHeader();
	}
	public void showList(int custId)
	{
		try
		{
			while(true)
			{
				System.out.println("Select 1: Show the product list and add to cart.\n2:View cart.\n3:Show previous orders.\n4:Checkout and show the bill.\n5: If you want to logout");
				int select=sc.nextInt();
				switch(select)
				{
					case 1:
						int i=1;
						con=sscon.getShopConnection();
						stmt=con.createStatement();			
						rs=stmt.executeQuery("select * from product");
						hmap.clear();
						
						while(rs.next())
						{
							//System.out.println(i+" : rs.getString(2)");
							hmap.put(rs.getString(2),rs.getInt(1));
						}	
						MyComparator comp = new MyComparator(hmap);
						Map<String, Integer> newMap = new TreeMap<String, Integer>(comp);
				        newMap.putAll(hmap);
				        int cnt=1;
				        for (Map.Entry<String,Integer> entry : newMap.entrySet())
				        {
				            System.out.println(cnt+" : " + entry.getKey());
				            cnt++;
				        }
				        
						System.out.println("Type the product name to add in the cart..");
						String prod=sc.next();
						if(hmap.containsKey(prod))
						{
							ll.add(new Integer(hmap.get(prod)));
						}
						break;
						
					case 2:
						int pcount=1;
						con=sscon.getShopConnection();
						stmt=con.createStatement();			
						rs=stmt.executeQuery("select * from shopping_cart where userid="+custId);
						
						System.out.println("Your cart contains following products:\n");
						while(rs.next())
						{
							rs2=stmt.executeQuery("select name from product where pid="+rs.getInt(2));
							System.out.println(pcount+": "+rs2.getString(1));
							pcount++;							
						}						
						
					break;
					case 3:
						showPreviousOrder(custId);
					break;
					case 4:
						addCartToDatabase(custId,ll);
					break;
					case 5:
						System.exit(0);
					default:
						System.out.println("Please select correct option");
			}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	private void showPreviousOrder(int custId)
	{
		try
		{
		int pcount=1;
		con=sscon.getShopConnection();
		stmt=con.createStatement();			
		rs=stmt.executeQuery("select * from order_list,shopping_Order where shopping_order.order_id=order_list.order_id and product.pid=order_list.pid and shopping_order.userid="+custId);
		
		System.out.println("Your previous orders contains following products:\n");
		while(rs.next())
		{
			System.out.println(pcount+": "+rs2.getString(1));
			pcount++;							
		}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	void addCartToDatabase(int custId, LinkedList<Integer> ll2) 
	{
		
		try 
		{
			con=sscon.getShopConnection();
			stmt=con.createStatement();
			for(Integer o:ll2)
			{
				stmt.executeUpdate("insert into shopping_cart values("+custId+","+o.intValue());
			}
			bil=new Bill();
			bil.showBill(custId);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		
		
	}

}
class MyComparator implements Comparator<Object> {
    Map<String, Integer> map;

        public MyComparator(Map<String, Integer> map) {
        this.map = map;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return (o2.toString()).compareTo(o1.toString());
    }
}
