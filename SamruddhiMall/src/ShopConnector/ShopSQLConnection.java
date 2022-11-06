package ShopConnector;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ShopSQLConnection 
{
	Connection con=null;
	Statement  stmt=null;
	public Connection getShopConnection()
	{
		try 
		{
		String url="jdbc:mysql://localhost:3306/shopping_cart";
		String userName="root";
		String pass="root";			
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,userName,pass);		
		}
		catch(Exception e)
		{
			System.out.println(e);			
		}		
		return con;		
	}	
}
