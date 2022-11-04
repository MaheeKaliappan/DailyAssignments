package com.zoho.javaprograms;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToPojoUsingObjectMapper {

	Scanner reader = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		JsonToPojoUsingObjectMapper jsonToPojoUsingObjectMapper = new JsonToPojoUsingObjectMapper();
		try {
			jsonToPojoUsingObjectMapper.addSingleValueInPojo();
			jsonToPojoUsingObjectMapper.addListOfValueInPojo();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	private void addListOfValueInPojo() throws IOException {
		System.out.println("List Of Employee Record ");
		System.out.println("How many Employee Values are stored now??");
		List<Employee> employeeList = new ArrayList<Employee>();
		int employeeListCount = reader.nextInt();
		for(int employeeCount = 0;employeeCount<employeeListCount;employeeCount++)
		{
			Employee employee = new Employee();
			System.out.println("Enter Employee Name");
			employee.setEmplyeeName(reader.next());
			System.out.println("Enter Employee Age");
			employee.setEmployeeAge(reader.nextInt());
			employeeList.add(employee);
			
		}
		ObjectMapper objectMapper = new ObjectMapper();
		
		System.out.println("List Of Value in Json Format : "+objectMapper.writeValueAsString(employeeList));
		System.out.println("Json Values Added In file");
		objectMapper.writeValue(new File("c://Users//mahee//Desktop//MaheeVk//jsonObject.json"), employeeList);
		printTheJsonValue(objectMapper);
	}

	private void printTheJsonValue(ObjectMapper objectMapper) throws JsonMappingException, JsonProcessingException {
		String jsonValue = "[{\"emplyeeName\":\"Kishoruuu\",\"employeeAge\":11},{\"emplyeeName\":\"sureshu\",\"employeeAge\":22},{\"emplyeeName\":\"muraleee\",\"employeeAge\":22}]";
		ObjectMapper objectMapper2 = new ObjectMapper();
		List<Employee> employeeList = objectMapper2.readValue(jsonValue,new TypeReference<List<Employee>>() {});
		for (Employee employee : employeeList) {
			System.out.println("Employee Name : "+ employee.getEmplyeeName()+ " Age : "+employee.getEmployeeAge());
		}
		
	}

	private void addSingleValueInPojo() throws IOException {
		Employee employee = new Employee();
		System.out.println("Single EMployee Record ");
		System.out.println("Enter Employee Name");
		employee.setEmplyeeName(reader.next());
		System.out.println("Enter Employee Age");
		employee.setEmployeeAge(reader.nextInt());
		ObjectMapper objectMapper = new ObjectMapper();
		
		System.out.println("Single Value in Json Format : "+objectMapper.writeValueAsString(employee));
		addAJsonDateInFile(objectMapper);
		
	}

	private void addAJsonDateInFile(ObjectMapper objectMapper) throws StreamWriteException, DatabindException, IOException {
		
		
	}

}
class Employee
{
	private  String emplyeeName;
	private  Integer  employeeAge;
	
	public Employee()
	{
		
	}
	public String getEmplyeeName() {
		return emplyeeName;
	}
	public void setEmplyeeName(String emplyeeName) {
		this.emplyeeName = emplyeeName;
	}
	public Integer getEmployeeAge() {
		return employeeAge;
	}
	public void setEmployeeAge(Integer employeeAge) {
		this.employeeAge = employeeAge;
	}
}
