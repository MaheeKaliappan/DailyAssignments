package com.zoho.javaprograms;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class PriorityQueueDemo {

	public static void main(String[] args) throws FileNotFoundException {
		PriorityQueueDemo priorityQueueDemo = new PriorityQueueDemo();
		priorityQueueDemo.addFunctionality();
    

	}

	private void addFunctionality() {
		//while(true)
		{
			Scanner reader = new Scanner(System.in);
			
			File file = new File("D:\\zoho_tenkasi\\fileOperation\\demo.txt");
			File fileOne = new File("D:\\zoho_tenkasi\\fileOperation\\createFileDemo.txt");
			File fileTwo   = new File("D:\\zoho_tenkasi\\MyLinkedList.txt");
			
			PriorityQueue<Double>priorityQueue = new PriorityQueue<Double>();
			PriorityQueue<File>priorityFileQueue = new PriorityQueue<>((a,b)->{
																				return (int)(a.length()-b.length());
																			});
			if(!(file.exists()))
			{
				System.out.println("File Not Found");
				
			}
			else
			{
				System.out.println("File here");
				priorityQueue.add((double)100.0);
				Double fileBytes = (double) file.length();
				priorityQueue.add(fileBytes);
				priorityQueue.add((double)fileOne.length());
				
				priorityQueue.add(fileBytes);
				priorityQueue.add((double)fileOne.length());
				priorityQueue.add(fileBytes);
				priorityQueue.add((double)fileOne.length());
				priorityQueue.add((double)100.0);
				
				priorityFileQueue.add(file);
				priorityFileQueue.add(fileTwo);
				priorityFileQueue.add(fileOne);
				
				
				priorityFileQueue.stream().forEach(fileDetails->System.out.println("File Name : "+fileDetails.getPath() + "Size :  "+fileDetails.length()));
				
				System.out.println();
				 while (!priorityFileQueue.isEmpty()) {
			            System.out.println(priorityFileQueue.poll().getPath() + " ");
			        }
				
			}
//			System.out.println(priorityQueue);
//			System.out.println(priorityQueue.size());
			 
			
			 
			 
			
			
			
		}
		
		
	}

}
