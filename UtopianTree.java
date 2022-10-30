package com.zoho.javaprograms;

import java.util.Scanner;

public class UtopianTree {

	public static void main(String[] args) {
	UtopianTree utopianTree = new UtopianTree();
	System.out.println(utopianTree.findTheHeight());

	}

	private int findTheHeight() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the years");
		int years = reader.nextInt();
		 int height=0;
		    for(int year=0;year<=years;year++){
		        if(year%2!=0)
		        {
		            height=height*2;
		        }
		        else 
		        {
		            height++;
		        }
		    }
		    return height;
		    }
	

}
