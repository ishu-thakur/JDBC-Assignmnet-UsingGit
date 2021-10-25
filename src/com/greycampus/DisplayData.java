package com.greycampus;

import java.util.ArrayList;

public class DisplayData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		RetriveData retriveData = new RetriveData();
		ArrayList<Employee> employeesData = retriveData.getAllData();
		employeesData.forEach(employee->{
			System.out.println(employee.getEno());
			System.out.println(employee.getName());
			System.out.println(employee.getSalary());
		});
	}

}
