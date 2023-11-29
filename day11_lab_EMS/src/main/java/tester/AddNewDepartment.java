package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.DepartmentDao;
import dao.DepartmentDaoImpl;
import pojos.Department;

public class AddNewDepartment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			System.out.println("Enter department details: Dept. Name, location \n");
			Department dept = new Department(sc.next(), sc.next());
			DepartmentDao dao = new DepartmentDaoImpl();
			String depart = dao.addDepartmentInDb(dept);
			System.out.println(depart);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
