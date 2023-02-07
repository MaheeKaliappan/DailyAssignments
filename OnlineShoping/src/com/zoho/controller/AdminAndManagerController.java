package com.zoho.controller;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.zoho.model.Product;
import com.zoho.model.User;

public class AdminAndManagerController {
	LoginPage loginPage = new LoginPage();
	public void  addInventory(String role) {
		Product product = new Product();
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Brand Name");
		product.setProductBrandName(reader.next());
		System.out.println("productName");
		product.setProductName(reader.next());
		System.out.println("product Quantity");
		product.setProductQuantity(reader.nextInt());
		System.out.println("product price");
		product.setProductPrice(reader.nextInt());
		product.setCreatedBy(role);
		loginPage.addInventory(product);
		
		}

	public void viewInventory(Map<String, Product> productDetails) {
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
				
				System.out.println("Product Added By        "+productDetail.getValue().getCreatedBy());
				System.out.println("Product Modified By     "+productDetail.getValue().getModifiedBy());
			}
			
		}
		
	}


	

	public void removeInventory() {
		Scanner reader = new Scanner(System.in);
		Product product = new Product();
		System.out.println("Brand Name");
		product.setProductBrandName(reader.next());
		System.out.println("productName");
		product.setProductName(reader.next());
		
		LoginPage loginPage = new LoginPage();
		boolean inventoryFound = loginPage.fetchInventoryRecord(product);
		if(inventoryFound)
		{
			loginPage.removeInventory(product);
		}
		else
		{
			System.out.println("Invalid manger mailId");
		}
		
	}

	public void updateInventory(String userRole) {
		Scanner reader = new Scanner(System.in);
		Product product = new Product();
		System.out.println("Brand Name");
		product.setProductBrandName(reader.next());
		System.out.println("productName");
		product.setProductName(reader.next());
		
		LoginPage loginPage = new LoginPage();
		boolean inventoryFound = loginPage.fetchInventoryRecord(product);
		if(inventoryFound)
		{
			product.setProductName(reader.next());
			System.out.println("product Quantity");
			product.setProductQuantity(reader.nextInt());
			System.out.println("product price");
			product.setProductPrice(reader.nextInt());
			product.setModifiedBy(userRole);
			loginPage.updateInventory(product);
		}
		else
		{
			System.out.println("Invalid Inventory name");
		}
		
		
		
	}

}
