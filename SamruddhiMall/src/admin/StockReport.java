package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ShopConnector.ShopSQLConnection;
public class StockReport {
	
	
	
	
	static PreparedStatement pst = null;
// establishing JDBC Connectivity

static ShopSQLConnection sscon=new ShopSQLConnection();
static Connection connection = sscon.getShopConnection();
public static void productINStock() {
//SQL Query to count Number of Product
String countProduct = "select count(*) from product;";

try {
pst = connection.prepareStatement(countProduct);
} catch (SQLException e) {
e.printStackTrace();
}
//SQL Query executed
try {
boolean iscounted = pst.execute();
if (iscounted == true)
System.out.println("Querry(to count product) executed ");
} catch (SQLException e) {
e.printStackTrace();
}
//Iterate resultset
try {
ResultSet rs = pst.executeQuery(countProduct);
rs.next();
int productCount = rs.getInt(1);
System.out.println("Number of Product in stock = " + productCount);
} catch (SQLException e) {
e.printStackTrace();
}
}
public static void generateStockReport() {
//SQL query
String stockReport = "select * from product;";
try {
pst = connection.prepareStatement(stockReport);
} catch (SQLException e) {
e.printStackTrace();
}
try {

pst.executeUpdate();
} catch (SQLException e) {
e.printStackTrace();
}
//display stock report
try {
ResultSet rs = pst.executeQuery(stockReport);
System.out.println(" :: Product Stock detail are ::");
while (rs.next()) {System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "
+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getInt(7)+" "+rs.getString(8)
+" "+rs.getString(9));}
} catch (SQLException e) {
e.printStackTrace();
}
//id,name,desc,category,brand,price,Quantity,manufacturing_date,expiry_date
//1 2 3 4 5 6 7 8 9
}
}
