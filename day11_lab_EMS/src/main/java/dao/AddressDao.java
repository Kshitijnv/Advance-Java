package dao;

import pojos.Address;

public interface AddressDao {
	// add a method to insert the address details and link employee
	String addEmpAddress(Long empId, Address add);
}
