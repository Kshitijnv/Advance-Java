package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="emp_add")
public class Address extends BaseEntity {
	@Column(length=100)
	private String lane1;
	@Column(length=100)
	private String lane2;
	@Column(length=20)
	private String city;
	@Column(length=20)
	private String country;
	@Column(length=20)
	private String state;
	@Column(length=20)
	private int pincode;
	
	@OneToOne	//1 Address --->1 employee..DOING purposly unidirection 
	@JoinColumn(name="emp_id",nullable = false) // For FK which takes references
	@MapsId//Common Share PK (Pk of Emp + Fk of Address--> Pk of Address	
	private Employee emp;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String lane1, String lane2, String city, String country, String state, int pincode) {
		super();
		this.lane1 = lane1;
		this.lane2 = lane2;
		this.city = city;
		this.country = country;
		this.state = state;
		this.pincode = pincode;
	}

	public String getLane1() {
		return lane1;
	}

	public void setLane1(String lane1) {
		this.lane1 = lane1;
	}

	public String getLane2() {
		return lane2;
	}

	public void setLane2(String lane2) {
		this.lane2 = lane2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "Address [lane1=" + lane1 + ", lane2=" + lane2 + ", city=" + city + ", country=" + country + ", state="
				+ state + ", pincode=" + pincode + "]";
	}
	
}
