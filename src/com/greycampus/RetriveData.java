package com.greycampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RetriveData {

	public ArrayList<Employee> getAllData() {

		Connection connection = null;
		Statement createStatement = null;
		ResultSet resultSet = null;
		ArrayList<Employee> empList = null;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##bms", "abc");
			createStatement = connection.createStatement();
			resultSet = createStatement.executeQuery("select * from table1");
			empList= new ArrayList<Employee>();
			while(resultSet.next())
			{
				Employee employee = new Employee();
				employee.setEno(resultSet.getInt("emp_no"));
				employee.setName(resultSet.getString("name"));
				employee.setSalary(resultSet.getDouble("salary"));
				empList.add(employee);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				createStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return empList;
	}
}
