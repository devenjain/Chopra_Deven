/*
 * Creator : Chopra Deven
 * Date of creation : 26/06/2021
 * 
 * Question 1 :		Write a program  to read a CSV file and print the same in the output file. 
 * 					This csv file contains three columns having numeric value. The output file
 * 					should additionally contain the sum of these numeric values.
 * 
 * */


package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Question2 {

	public static void main(String[] args) {
		
		String file = "src\\file1.csv";
		
		BufferedReader reader = null;
		
		String line = "";
		
		try {
			
			reader = new BufferedReader(new FileReader(file));
			
			System.out.printf("%-10s %-10s %-13s %-30s","collumn1","column2","collumn3","Addition");
			System.out.println();
			
			while((line = reader.readLine()) != null) {
				
				String[] row = line.split(",");
				int sum = 0;
				
				for(String index : row) {
					System.out.printf("%-13s",index);
					sum += Integer.parseInt(index);
				}
				System.out.printf("%-13s",sum);
				System.out.println();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
