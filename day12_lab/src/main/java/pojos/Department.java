package pojos;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "departments")
public class Department extends BaseEntity {
	@Column(name = "dept_name", length = 20)
	private String deptName;
	@Column(length = 20)
	private String location;

	// association property
	@OneToMany(mappedBy = "mydept" ,cascade = CascadeType.ALL)
	private List<Employee> employees = new ArrayList<>();

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(String deptName, String location) {
		super();
		this.deptName = deptName;
		this.location = location;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Department [id: "+getId()+"deptName=" + deptName + ", location=" + location + "]";
	}
	//helper method
	public void addEmployee(Employee emp) {
		employees.add(emp);
		emp.setMydept(this);
	}
	public void removeEmployee(Employee emp) {
		employees.remove(emp);
		emp.setMydept(null);
	}
}
