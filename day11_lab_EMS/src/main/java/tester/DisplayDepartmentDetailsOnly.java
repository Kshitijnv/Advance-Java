package tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.DepartmentDao;
import dao.DepartmentDaoImpl;
import pojos.Department;

import static utils.HibernateUtils.getFactory;

public class DisplayDepartmentDetailsOnly {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			System.out.println("Enter department id : ");
			DepartmentDao dao = new DepartmentDaoImpl();
			Department detailsById = dao.getDepartmentDetailsById(sc.nextLong());
			System.out.println(detailsById); //detailsById.toString()
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
