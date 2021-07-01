/*
 * Creator : Chopra Deven
 * Date of creation : 30/06/2021
 * 
 * Question 5 : 	Write a program to store the value in Hashmap (key, store) and then search those given value from the hashmap and print it.
 * 					a.	Name is key and age is value so store some sample values like
					i.	(Ram, 36), (shyam,60)

 * 
 * */

package com;

import java.util.HashMap;
import java.util.Scanner;

public class Question5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		while(true) {
		
			System.out.println();
			System.out.println("1 - Enter Values");
			System.out.println("2 - Search");
			System.out.println("3 - Print All Values");
			System.out.println("4 - Exit");
			System.out.print("\nEnter your choice : ");
			int input = sc.nextInt();
			System.out.println();
			
			switch (input) {
			case 1:
				
				try {
					System.out.print("Enter name : ");
					String name = sc.next();
					
					System.out.print("Enter Age : ");
					int age = sc.nextInt();
									
					map.put(name, age);
					
					System.out.println("\nData Entered Successfull");
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
				
				break;
				
			case 2 : 
				
				try {
					System.out.println("Ente	r name which you want to search : ");
					String search = sc.next();
					
					if (map.containsKey(search)) {
					Integer value = map.get(search);
					System.out.println("Searched name founde\nAge of " +search+ " is " + value );
				}
					else {
						System.out.println("There is no name as \"" + search + "\"");
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
				break;
				
			case 3 : 
					
				for (HashMap.Entry<String,Integer> entry : map.entrySet())
		            System.out.println("Key = " + entry.getKey() +
		                             ", Value = " + entry.getValue());
				
				break;
				
			case 4:
				System.exit(0);
					
			default:
				System.out.println("Invalid Input!!");
				break;
			}
		
		}
	}

}
