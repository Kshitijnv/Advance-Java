package dao;

import pojos.Department;
import pojos.Employee;

public interface DepartmentDao {
	// add a method to Insert a department
	String addDepartmentInDb(Department dept);

//add a method fetch the department details by id
	Department getDepartmentDetailsById(long nextLong);

//add a method to delete the department by name
	String deleteDepartmentDetails(String deptName);
//add a method to display dept and emps
	Department displayDepartmentDetailswithEmployee(String deptName);
	//add a method to display dept and emps with join fetch
	Department displayDepartmentDetailswithEmployeeWithJoin(String next);

	String addDepartmentWithEmp(Department dept, Employee[] emp);
}
