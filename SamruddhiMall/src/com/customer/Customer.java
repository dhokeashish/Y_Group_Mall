package com.customer;

import java.util.Scanner;

import com.validations.ValidationCheck;

public class Customer {
	
	int userid;
	String phoneNumber, cust_name,email,city,streetaddr,postCode,password;
	Scanner sc=new Scanner(System.in);
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword() {
		String pass=sc.nextLine();
		if(pass=="") {
			System.out.println("Please do not enter blank password..");
			setPassword();
			}
		else if(ValidationCheck.checkChar(pass))
		this.password = password;
	}
	
	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) 
	{
		
		
		 
		this.userid = userid;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the cust_name
	 */
	public String getCust_name() {
		return cust_name;
	}

	/**
	 * @param cust_name the cust_name to set
	 */
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the streetaddr
	 */
	public String getStreetaddr() {
		return streetaddr;
	}

	/**
	 * @param streetaddr the streetaddr to set
	 */
	public void setStreetaddr(String streetaddr) {
		this.streetaddr = streetaddr;
	}

	/**
	 * @return the postCode
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public void getCustomerData()
	{
		
	}
	public static void main(String[] args) {
		

	}

}
