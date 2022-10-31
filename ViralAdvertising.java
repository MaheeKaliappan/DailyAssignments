package com.zoho.javaprograms;

import java.util.Scanner;

public class ViralAdvertising {

	public static void main(String[] args) {
		ViralAdvertising viralAdvertising = new ViralAdvertising();
		System.out.println(viralAdvertising.findTheCumulative());

	}

	private int findTheCumulative() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the dayCount");
		int dayCount = reader.nextInt();
		 int cumulative=0,people=5;
		    for(int i=1;i<=dayCount;i++)
		    {                             
		        int liked=people/2;           
		        int shared=liked*3;      
		        cumulative+=liked;  
		        
		        people=shared;                 
		       
		    }
		    return cumulative;
		    
		
	}

}
