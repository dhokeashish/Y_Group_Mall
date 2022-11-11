package com.admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.shopconnector.ShopSQLConnection;


//class to add , update , delete product from database
public class ProductUpdate {
static PreparedStatement pst = null;
//establishing JDBC Connectivity
static ShopSQLConnection  sscon=new ShopSQLConnection();
static Connection connection = sscon.getShopConnection();
// :: method to add product to database table 'product' ::
public static void addProduct() {
int id ,price,Quantity; String name,category, brand,desc;
String manufacturing_date = "yyyy-MM-dd"; String expiry_date = "yyyy-MM-dd";
// SQL Query for addition of new product to database table
String addQuery = "INSERT INTO product (id,name,desc,category,brand,price,Quantity,manufacturing_date,expiry_date)"
+ "values(?,?,?,?,?,?,?)";
try {
pst = connection.prepareStatement(addQuery);
} catch (SQLException e) {
e.printStackTrace();
}
//getting product information from admin
Scanner sc = new Scanner(System.in);
System.out.println("enter product id");
id = sc.nextInt();
System.out.println("enter product name for id="+id);
name = sc.next();
System.out.println("enter product Description of product "+name);
desc = sc.next();
System.out.println("enter product category");
category = sc.next();
System.out.println("enter product brand");
brand = sc.next();
System.out.println("enter price of "+name);
price = sc.nextInt();
System.out.println("enter product quantity");
Quantity = sc.nextInt();
System.out.println("enter product manufacturing_date in yyyy-MM-dd format ");
manufacturing_date = sc.next();
System.out.println("enter product expiry_date in yyyy-MM-dd format");
expiry_date = sc.next();
try {
pst.setInt(1, id);
pst.setString(2,name);
pst.setString(3,desc);
pst.setString(4,category);
pst.setString(5,brand);
pst.setInt(6,price);
pst.setInt(7,Quantity);
pst.setString(8,manufacturing_date);
pst.setString(9,expiry_date);
} catch (SQLException e) {
e.printStackTrace();
}
try {
int rowsAffected = pst.executeUpdate();
if (rowsAffected==1) System.out.println("Record with product id "+id+"is added to database succefully");
} catch (SQLException e) {
e.printStackTrace();
}
sc.close();
}
//:: method to delete product from database table 'product' by id number or name ::
// :: using methodOverloading ::
//delete product using product id.
public static void deleteProduct(int id_no) {
// SQL query to delete product from database.
String deleteQuerry = "DELETE FROM product where id=?";
try {
pst = connection.prepareStatement(deleteQuerry);

} catch (SQLException e1) {
e1.printStackTrace();
}
try {
pst.setInt(1, id_no);
} catch (SQLException e) {
e.printStackTrace();
}
// executed the SQL Query
try {
int rowsAffected = pst.executeUpdate();
if (rowsAffected==1) System.out.println("Record with product id "+id_no+"is deleted from database succefully");
} catch (SQLException e) {
e.printStackTrace();
}
}
//delete product using product name
public static void deleteProduct(String product_name) {
	ShopSQLConnection sscon=new ShopSQLConnection();
	Connection connection = sscon.getShopConnection();
//SQL query to delete product
String deleteQuerry = "DELETE FROM product where name=?";
try {
pst = connection.prepareStatement(deleteQuerry);
} catch (SQLException e1) {
e1.printStackTrace();
}
try {
pst.setString(1, product_name);
} catch (SQLException e) {
e.printStackTrace();
}
// executed the SQL Query
try {
int rowsAffected = pst.executeUpdate();
if (rowsAffected==1) System.out.println("Record with product name "+product_name+"is deleted from database succefully");
} catch (SQLException e) {
e.printStackTrace();
}
}
// :: method to update product info ::
//update product name of given product id.
public static void updateProduct_name(int id,String new_name) {
String updateQuery = "UPDATE product SET name = ? WHERE id=?";
try {
pst = connection.prepareStatement(updateQuery);
} catch (Exception e) {
e.printStackTrace();
}
try {
pst.setString(1, new_name);
} catch (SQLException e) {
e.printStackTrace();
}
try {
pst.setInt(2, id);
} catch (SQLException e) {
e.printStackTrace();
}
}
//update product id of given product name.
public static void updateProduct_id(String name,int new_id) {
String updateQuery = "UPDATE product SET id = ? WHERE name=?";
try {
pst = connection.prepareStatement(updateQuery);
} catch (Exception e) {
e.printStackTrace();
}
try {
pst.setInt(1,new_id);
} catch (SQLException e) {
e.printStackTrace();
}
try {
pst.setString(2, name);
} catch (SQLException e) {
e.printStackTrace();
}
}
}