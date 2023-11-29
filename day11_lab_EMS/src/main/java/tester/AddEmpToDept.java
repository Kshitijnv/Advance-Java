package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import pojos.Employee;
import pojos.EmployeeType;

public class AddEmpToDept {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			System.out.println(
					"Enter employee details: firstName, lastName, email,  join Date, password,  salary,emp type");
			Employee emp = new Employee(sc.next(), sc.next(), sc.next(), LocalDate.parse(sc.next()), sc.next(),
					sc.nextDouble(), EmployeeType.valueOf(sc.next().toUpperCase()));
			System.out.println("Enter department id ");
			EmployeeDao empDao = new EmployeeDaoImpl();
			// invoking emp dao method to insert emp
			String addEmployeeInDept = empDao.addEmployeeInDept(emp, sc.nextLong());
			System.out.println(addEmployeeInDept);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
