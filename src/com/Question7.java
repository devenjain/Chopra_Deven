/*
 * Creator : Chopra Deven
 * Date of creation : 01/07/2021
 * 
 * Question 7 : Write a program that take the command line input and print all received inputs

 * 
 * */

package com;

public class Question7 {

	public static void main(String[] args) {
		
		try {
			
			for (String arguments : args) {
				
				System.out.println(arguments);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		

	}

}
