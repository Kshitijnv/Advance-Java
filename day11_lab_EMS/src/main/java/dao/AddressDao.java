package dao;

import java.util.List;

import pojos.Address;
import pojos.Employee;

public interface AddressDao {
	// add a method to insert the address details and link employee
	String addEmpAddress(Long empId, Address add);

	String displayDetails(long nextLong);

	List<String> displayLastName(String city);
}
