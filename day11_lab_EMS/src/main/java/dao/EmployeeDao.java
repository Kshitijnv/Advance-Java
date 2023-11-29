package dao;

import pojos.Employee;

public interface EmployeeDao {
	//add a method to add employee in department
	String addEmployeeInDept(Employee emp,Long deptId);
}
