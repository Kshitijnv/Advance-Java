package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.DepartmentDao;
import dao.DepartmentDaoImpl;
import pojos.Department;

public class DisplayDepartmentDetailsWithEmpsWithJoinFetch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = getFactory();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter department name: ");
		DepartmentDao dao = new DepartmentDaoImpl();
		Department result = dao.displayDepartmentDetailswithEmployeeWithJoin(sc.next());
		System.out.println(result);
		result.getEmployees().forEach(System.out::println);
		sc.close();
		sf.close();
	}

}
