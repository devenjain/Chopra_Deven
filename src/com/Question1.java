/*
 * Creator : Chopra Deven
 * Date of creation : 26/06/2021
 * 
 * Question 1 : 1.	Write a function to convert a decimal number string into binary string. For example , 
 * string A contains “123” which is decimal value 123. Convert this string into binary string.
 * 
 * */

package com;

import java.util.Scanner;

public class Question1 {

	public static String decToBin(int n) {
		
		 int[] binaryNum = new int[1000];
		   
	        // counter for binary array
	        int i = 0;
	        String binary = "";
	        
	        while (n > 0) 
	        {
	            // storing remainder in binary array
	            binaryNum[i] = n % 2;
	            n = n / 2;
	            i++;
	        }
	   
	        // converting binary value into String
	        for (int j = i - 1; j >= 0; j--) 
	        	binary += String.valueOf(binaryNum[j]);
	        
	        return binary;
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("Enter decimal String : ");
			String decString = sc.next();
			
			int decimal = Integer.parseInt(decString);
			
			System.out.println("\nBinary : " + decToBin(decimal));
			
		//	or we can use built in function
		//	System.out.println("\nBinary : " + Integer.toBinaryString(decimal));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			sc.close();
		}
		
	}

}
