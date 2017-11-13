package com.dao.singletondi.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDetails {
	
	
	//Constructor
	Connection connection;
	public EmployeeDetails() {
		connection = DBCONNECTION.createConnection();
	}
	
	
	

	public void addEmployee(int emp_id, String emp_name, double salary){
		try{
			String query = "insert into employee values(?,?,?)";
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setInt(1, emp_id);
			pStatement.setString(2, emp_name);
			pStatement.setDouble(3, salary);
								
			int result = pStatement.executeUpdate();
			
			if(result > 0){
				System.out.println("Employee created");
			}
			
			connection.close();
			
		}catch (Exception e) {	e.printStackTrace();	}
	}

	public void updateEmployee(int emp_id, double salary){
		try{			
			String query = "update employee set salary = salary+? where emp_id=?";
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setDouble(1, salary);
			pStatement.setInt(2, emp_id);
			
			int result = pStatement.executeUpdate();
			
			if(result > 0)
				System.out.println(emp_id+" Employee is updated");
			else
				System.out.println(emp_id+" Employee is not existing");
		
		}catch (Exception e) {e.printStackTrace();}
	}

	
	public void deleteEmployee(int emp_id) {
		try {
			String query = "delete from employee where emp_id = ?";
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setInt(1, emp_id);

			int result = pStatement.executeUpdate();

			if (result > 0)
				System.out.println(emp_id + " employee is deleted");
			else
				System.out.println(emp_id + " employee is not existing");

		} catch (Exception e) { 	e.printStackTrace(); 	}

	}
	
	
	public void getAllEmployees(){
		try{			
			String query = "select * from employee";
			PreparedStatement pStatement = connection.prepareStatement(query);
			
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()){
				System.out.println(resultSet.getInt("emp_id")+"\t"+resultSet.getString("emp_name")+"\t"+resultSet.getDouble(3));
			}
			
		} catch (Exception e) { 	e.printStackTrace(); 	}

	}
	
	
	
	public void searchEmployee(int emp_id) {
		try {
			String query = "select * from employee where emp_id = ?";
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setInt(1, emp_id);
			
			ResultSet resultSet = pStatement.executeQuery();
			
			if(resultSet.next()){
				System.out.println(resultSet.getInt("emp_id")+"\t"+resultSet.getString("emp_name")+"\t"+resultSet.getDouble(3));
			}
			else{
				System.out.println(emp_id+" employee not found");
			}
						
		} catch (Exception e) { 	e.printStackTrace(); 	}
	}

}

