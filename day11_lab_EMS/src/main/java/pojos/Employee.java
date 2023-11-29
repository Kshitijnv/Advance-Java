package pojos;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="emps")
public class Employee extends BaseEntity{
	@Column(name="first_name", length=30)
	private String firstName;
	@Column(name="last_name", length=30)
	private String lastName;
	@Column(length=30,unique = true)
	private String email;
	@Column(name="join_date")
	private LocalDate joinDate;
	@Column(length=20,nullable = false)
	private String password;
	private Double salary;
	@Enumerated(EnumType.STRING)
	@Column(name="emp_type")
	private EmployeeType type;
	@ManyToOne
	@JoinColumn(name="dept_id")
	private Department mydept;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	
	public Employee(String firstName, String lastName, String email, LocalDate joinDate, String password, Double salary,
			EmployeeType type) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.joinDate = joinDate;
		this.password = password;
		this.salary = salary;
		this.type = type;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public EmployeeType getType() {
		return type;
	}

	public void setType(EmployeeType type) {
		this.type = type;
	}

	public Department getMydept() {
		return mydept;
	}

	public void setMydept(Department mydept) {
		this.mydept = mydept;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", joinDate="
				+ joinDate + ", salary=" + salary + ", type=" + type + ", mydept=" + mydept + "]";
	}
	
}
