package com.zoho.javaprograms;

public class PrintStackTrace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			int num =6/0;
			
		}
		catch(Exception e) {
			System.out.println("printStacktrace()");
		    e.printStackTrace();
			//System.out.println(e);
		    System.out.println("toString()");
		    System.out.println(e.toString());
		    System.out.println("getMessage()");
		    System.out.println(e.getMessage());
			
			
		}

	}

}
