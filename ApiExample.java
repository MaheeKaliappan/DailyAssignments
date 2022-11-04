package com.zoho.javaprograms;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class ApiExample {

	public static void main(String[] args) throws IOException {
		ApiExample apiExample = new ApiExample();
		try {
			URL url = new URL("https://reqres.in/api/users/2 ");
			HttpsURLConnection  httpsURLConnection = (HttpsURLConnection)url.openConnection();
			httpsURLConnection.setRequestMethod("GET");
			int responseCode =  httpsURLConnection.getResponseCode();
			System.out.println(responseCode);
			if(responseCode != 200)
			{
				System.out.println("Url MisMatched");
			}
			else
			{
				StringBuilder stringValue = new StringBuilder();
				Scanner reader = new Scanner(url.openStream());
				while(reader.hasNext()){  
					stringValue.append(reader.nextLine()+"\n"); 
					
					}
				System.out.println(stringValue);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

