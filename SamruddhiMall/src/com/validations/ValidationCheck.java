package com.validations;

public class ValidationCheck 
{
	

	public static boolean checkChar(String str) {
		 return str.matches( "[A-Z][a-z]*" );
	}
	

}
