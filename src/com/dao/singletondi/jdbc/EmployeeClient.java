package com.dao.singletondi.jdbc;

import java.util.Scanner;

public class EmployeeClient {

	
	public static void menu(){
		System.out.println("1. Add an Employee");
		System.out.println("2. Update an Employee");
		System.out.println("3. Delete an Employee");
		System.out.println("4. Get all Employees Details");
		System.out.println("5. Serach for an Employee");
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		menu();
		int emp_id;
		String emp_name;
		double salary;
		System.out.println("Enter your choice?");
		int choice = scanner.nextInt();
		
		EmployeeDetails eDetails = new EmployeeDetails();
		switch (choice) {
		case 1:
			System.out.println("Enter Employee ID, Employee Name and his Salary");
			emp_id = scanner.nextInt();
		    emp_name = scanner.next();
			salary = scanner.nextDouble();
			
			eDetails.addEmployee(emp_id, emp_name, salary);
			break;
		case 2:
			System.out.println("Enter pno and price");
			emp_id = scanner.nextInt();
			salary = scanner.nextDouble();
			
			eDetails.updateEmployee(emp_id, salary);
			break;
		case 3:
			emp_id = scanner.nextInt();
			eDetails.deleteEmployee(emp_id);
			break;
		case 4:
			eDetails.getAllEmployees();
			break;
		case 5:
			System.out.println("Which record you want to search?");
			emp_id = scanner.nextInt();
			eDetails.searchEmployee(emp_id);

			break;

		default:
			break;
		}
		
		
		scanner.close();
	}
	

}