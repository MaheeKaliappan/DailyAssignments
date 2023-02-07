package com.zoho.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.zoho.model.User;
import com.zoho.model.Product;

public class UserController {
	LoginPage loginPage = new LoginPage();
//	Scanner scanner = new Scanner(System.in);
//	 int estimatBalance =0;
//	 int rewardPoint = 0;
//	static List<Product>cartList = new ArrayList<Product>();
//	public void viewProducts(List<Product> producList) {
//		
//		if(producList.size()==0)
//		{   
//			//Purchasing p = new Purchasing();
//			p.userFunctionality();
//		}
//		else
//		{
//			for(int i=0;i<producList.size();i++)
//			{
//				System.out.println("Product Name            "+producList.get(i).getProductName());
//				System.out.println("Product quantity        "+producList.get(i).getProductQuantity());
//				System.out.println("Product price           "+producList.get(i).getProductPrice());
//				System.out.println("Product id              "+producList.get(i).getProductId());
//				//System.out.println("Product Added By        "+producList.get(i).getCreatedBy());
//				//System.out.println("Product Modified By       "+producList.get(i).getModifiedBy());
//			}
//		}
//		
//	}
//
//	public void addToCart() 
//	{
//		//Scanner scanner = new Scanner(System.in);
//		Product product = new Product();
//		System.out.println("product name ");
//		product.setProductName(scanner.next());
//		System.out.println("product id");
//		product.setProductId(scanner.nextInt());
//		System.out.println("product quantity");
//		product.setProductQuantity(scanner.nextInt());
//		System.out.println("product price");
//		product.setProductPrice(scanner.nextInt());
//		cartList.add(product);
//		System.out.println("add successfully");
//		System.out.println(cartList.size());
//		p.userFunctionality();
//	
//
//		
//		
//	}
//
//	public void removeCart() {
//		if(cartList.size()==0)
//		{
//			System.out.println("cartlist empty");
//		}
//		else
//		{
//			
//			System.out.println("product id");
//			int id = scanner.nextInt();
//			for(int i =0;i<cartList.size();i++)
//			{
//				if(cartList.get(i).getProductId()==id)
//				{
//					cartList.remove(i);
//				}
//			}
//			System.out.println("remove successfully");
//		}
//		p.userFunctionality();
//		
//
//	}
//
//	public void viewCart(User person) {
//		System.out.println(cartList.size());
//		System.out.println("balance "+person.getUserBalance());
//		if(cartList.size()==0)
//		{
//			System.out.println("list empty");
//			
//		}
//		else
//		{
//			//int estimatBalance =0;
//			for(int i=0;i<cartList.size();i++)
//			{
//				System.out.println("Product Name            "+cartList.get(i).getProductName());
//				System.out.println("Product quantity        "+cartList.get(i).getProductQuantity());
//				System.out.println("Product price           "+cartList.get(i).getProductPrice());
//				System.out.println("Product id              "+cartList.get(i).getProductId());
//				estimatBalance+=cartList.get(i).getProductPrice();
//				//System.out.println("Product Added By        "+producList.get(i).getCreatedBy());
//				//System.out.println("Product Modified By       "+producList.get(i).getModifiedBy());
//			}
//			System.out.println("estimate balance "+estimatBalance);
//		}
//		p.userFunctionality();
//		
//		
//	}
//
//	public User addMoneyToWallet(User person) {
//		person.setUserBalance(person.getUserBalance()+5000);
//		return person;
//		
//	}
//
//	public void viewWallet(User person) {
//		System.out.println("balance "+person.getUserBalance());
//		
//	}
//
//	public void rewardPoints() {
//		rewardPoint=estimatBalance/100;
//		System.out.println("Reward Point "+rewardPoint);
//		
//	}

	public void viewProducts(Map<String, Product> productDetails) {
		if(productDetails.size()==0)
		{
			System.out.println("Prduct List is empty");
		}
		else
		{
			for(Map.Entry<String, Product> productDetail : productDetails.entrySet())
			{
				System.out.println("Product Name            "+productDetail.getKey());
				System.out.println("Product quantity        "+productDetail.getValue().getProductPrice());
				System.out.println("Product price           "+productDetail.getValue().getProductQuantity());
				System.out.println("Product id              "+productDetail.getValue().getProductId());
				
			}
			
		}
		
	}

	public void addToCart() {
		Scanner scanner = new Scanner(System.in);
		Product product = new Product();

		System.out.println("Brand Name");
		product.setProductBrandName(scanner.next());
		System.out.println("productName");
		product.setProductName(scanner.next());
		System.out.println("product id");
		product.setProductId(scanner.nextInt());
		System.out.println("product quantity");
		product.setProductQuantity(scanner.nextInt());
		System.out.println("product price");
		product.setProductPrice(scanner.nextInt());
		loginPage.addCart(product);
		System.out.println("add successfully");
		
		
	}

	public void removeCart() {
		Scanner scanner = new Scanner(System.in);
		Product product = new Product();
		System.out.println("Brand Name");
		product.setProductBrandName(scanner.next());
		System.out.println("product name ");
		product.setProductName(scanner.next());
		boolean cartFound = loginPage.fetchCartRecord(product);
		if(cartFound)
		{
			loginPage.removeCart(product);
		}
		else
		{
			System.out.println("Invalid manger mailId");
		}
		
	}

	public void viewCart(String userRole, Map<String, List<Product>> cartDetails, Map<String, User> userDetails, String userMail) {
		if(cartDetails.containsKey(userRole))
		{
			int estimatedBill =0;
			System.out.println("Current Balance "+userDetails.get(userMail).getUserBalance());
			for(int index = 0;index<cartDetails.get(userRole).size();index++)
			{
				System.out.println("Product Name            "+cartDetails.get(userRole).get(index).getProductBrandName());
				System.out.println("Product quantity        "+cartDetails.get(userRole).get(index).getProductPrice());
				System.out.println("Product price           "+cartDetails.get(userRole).get(index).getProductQuantity());
				System.out.println("Product id              "+cartDetails.get(userRole).get(index).getProductId());
				estimatedBill+=cartDetails.get(userRole).get(index).getProductQuantity();
			}
			System.out.println("Estimated Bill "+estimatedBill);
		}
		else
		{
			System.out.println("User Not Found");
		}
	
		
	}

}
