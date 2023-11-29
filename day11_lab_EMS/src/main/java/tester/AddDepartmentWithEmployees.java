package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.DepartmentDao;
import dao.DepartmentDaoImpl;
import pojos.Department;
import pojos.Employee;
import pojos.EmployeeType;

public class AddDepartmentWithEmployees {

	public static void main(String[] args) {
		SessionFactory sf = getFactory();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter department details : deptName, location");
		Department dept = new Department(sc.next(), sc.next());
		System.out.println("Enter number of employee to added ");
		int count = sc.nextInt();
		Employee emp[] = new Employee[count];
		for (int i = 0; i < count; i++) {
			System.out.println(
					"enter employee details:firstName,lastName, email, joinDate, password, salary,EmployeeType type");
			emp[i] = new Employee(sc.next(), sc.next(), sc.next(), LocalDate.parse(sc.next()), sc.next(),
					sc.nextDouble(), EmployeeType.valueOf(sc.next().toUpperCase()));
		}
		DepartmentDao dao = new DepartmentDaoImpl();
		String msg = dao.addDepartmentWithEmp(dept,emp);
		System.out.println(msg);
		sc.close();
		sf.close();
	}

}
