package customer;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import ShopConnector.ShopSQLConnection;
import admin.Admin;
import header.AllHeader;
import shopping.ShowList;
import header.AllHeader;

public class CustomerModule 
{
	String admin_login_name="Smruddhi",password="12345";
	Scanner sc=new Scanner(System.in); 
	ShopSQLConnection sscon=null;
	public CustomerModule()
	{
		sscon=new ShopSQLConnection();
	}
	

	public void showCustomerModule() {
		
		 		
		AllHeader h1=new AllHeader();
		h1.addHeader();
		
		System.out.println("Select 1 if you are existing customer and if you want to login.\nSelect 2 if you want to sign up.");
		int option=sc.nextInt();
		if(option==1)
			loginCustomer();
		else 
		{
			registerCustomer();
		}
	}
	void loginCustomer()
	{
		
		try {
			Connection con=sscon.getShopConnection();
			Statement stmt=con.createStatement();
			int login;
			String pass;
			System.out.println("Enter User Name :");
			login=sc.nextInt();
			System.out.println("Enter Password :");
			pass=sc.next();
			ResultSet rs=stmt.executeQuery("select userid,password from customer where userid='"+login+"' and password='"+pass+ "'");
			if(!(rs.next())) 
			{
				System.out.println("Login fail. Please login again!!!");
				loginCustomer();
			}
			else 
			{
				ShowList ob=new ShowList ();
				ob.showList(login);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	void registerCustomer()
	{
		Customer c=new Customer();
	
		try 
		{
			Connection con=sscon.getShopConnection();
			Statement stmt=con.createStatement();
			
			System.out.println("Enter your id in numeric form:");
			int id=sc.nextInt();
			ResultSet rs=stmt.executeQuery("select userid from customer where userid= "+id);
			if(!(rs.next())) {
			c.setUserid(id);
			System.out.print("Enter your Password");
			c.setPassword(sc.nextLine());
			
			System.out.print("Enter your Full Name");
			c.setCust_name(sc.nextLine());
			
			System.out.print("Enter your Phone Number");
			c.setPhoneNumber(sc.nextLine());
			
			System.out.print("Enter your Email");
			c.setEmail(sc.nextLine());
			System.out.print("Enter your City");
			c.setCity(sc.nextLine());
			System.out.print("Enter your Street Address");
			c.setStreetaddr(sc.nextLine());
			System.out.print("Enter your Pin Code");
			c.setPostCode(sc.nextLine());
			String qry="insert into customer values("+c.userid+",'"+c.phoneNumber+"','"+c.cust_name+"','"+c.email+"','"+c.city+"','"+c.postCode+"','"+c.password+"')";
			int lcount=stmt.executeUpdate(qry);
			if(lcount!=0)
			{
				System.out.println("You are regestered successfully!!!!\nPlease Login now");
				loginCustomer();				
			}
			
			}
			else
			{
				System.out.println(id+"  this user name is already exist. Please choose new one");
				registerCustomer();
			}		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	

}
